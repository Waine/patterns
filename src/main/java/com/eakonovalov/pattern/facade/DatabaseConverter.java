package com.eakonovalov.pattern.facade;

import org.apache.commons.io.IOUtils;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Component;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.sql.DataSource;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.sql.*;
import java.util.Iterator;

/**
 * @author Waine
 * @version 1.0
 * @created 11-���-2017 21:19:43
 */
@Component
public class DatabaseConverter {

    private DataSource dataSource;

    /**
     * @param tableName
     * @param fileName
     */
    public void exportToExcel(String tableName, String fileName) {
        SXSSFWorkbook workbook = new SXSSFWorkbook(100);
        workbook.setCompressTempFiles(true);
        Sheet sheet = workbook.createSheet(tableName);

        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DataSourceUtils.getConnection(dataSource);
            ps = con.prepareStatement("SELECT * FROM " + tableName);
            ResultSetMetaData md = ps.getMetaData();

            Row row = sheet.createRow(0);

            CellStyle cellStyle = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            cellStyle.setFont(font);

            for (int i = 0; i < md.getColumnCount(); i++) {
                Cell cell = createCell(row, i, md.getColumnName(i + 1));
                cell.setCellStyle(cellStyle);
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                row = sheet.createRow(sheet.getLastRowNum() + 1);
                for (int i = 0; i < md.getColumnCount(); i++) {
                    createCell(row, i, rs.getString(i + 1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.closeStatement(ps);
            DataSourceUtils.releaseConnection(con, dataSource);
        }

        saveWorkbook(workbook, fileName);
    }

    private Cell createCell(Row row, int index, String value) {
        Cell cell = row.createCell(index);
        cell.setCellType(CellType.STRING);
        cell.setCellValue(value);

        return cell;
    }

    private void saveWorkbook(Workbook workbook, String fileName) {
        OutputStream out = null;
        try {
            out = new BufferedOutputStream(new FileOutputStream(new File(fileName)));
            workbook.write(out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(out);
        }
    }

    /**
     * @param fileName
     * @param tableName
     */
    public void importFromExcel(String fileName, String tableName) {
        InputStream sheet = null;
        try {
            OPCPackage pkg = OPCPackage.open(fileName);
            XSSFReader r = new XSSFReader(pkg);
            Iterator<InputStream> sheets = r.getSheetsData();
            if (sheets.hasNext()) {
                sheet = sheets.next();
                SAXParserFactory.newInstance().newSAXParser()
                        .parse(new InputSource(sheet), new SheetHandler(r.getSharedStringsTable()));
            }
        } catch (ParserConfigurationException | OpenXML4JException | SAXException | IOException e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(sheet);
        }


/*
        StringBuilder sb = new StringBuilder();
        Sheet sheet = workbook.getSheetAt(0);
        sb.append("CREATE TABLE ").append(tableName).append(" (");
        Row row = sheet.getRow(0);
        for(int i = 0; i < row.getLastCellNum(); i++) {
            sb.append(row.getCell(i).getStringCellValue()).append(" VARCHAR(255),");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");

        Connection con = null;
        Statement stmt = null;
        try {
            con = DataSourceUtils.getConnection(dataSource);
            stmt = con.createStatement();
            stmt.execute(sb.toString());

            for(int i = 1; i < sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                sb = new StringBuilder();
                sb.append("INSERT INTO ").append(tableName).append(" VALUES (");
                for(int j = 0; j < row.getLastCellNum(); j++) {
                    sb.append("'").append(row.getCell(j).getStringCellValue()).append("', ");
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append(")");

                stmt.execute(sb.toString());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.closeStatement(stmt);
            DataSourceUtils.releaseConnection(con, dataSource);
        }
        */
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
