package com.eakonovalov.pattern.adapter;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Waine
 * @version 1.0
 * @created 04-Feb-2017 0:56:05
 */
public class SSMLHandler extends DefaultHandler {

    private Workbook wb;

    private Sheet sheet;
    private Row row;
    private Cell cell;
    private CellType type;
    private StringBuilder data;

    public SSMLHandler(Workbook wb) {
        this.wb = wb;
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (data != null) data.append(String.copyValueOf(ch, start, length).trim());
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("Data".equals(qName)) {
            switch (type) {
                case STRING:
                    cell.setCellValue(data.toString());
                    break;
                case NUMERIC:
                    cell.setCellValue(Double.valueOf(data.toString()));
                    break;
                default:
                    cell.setCellValue(data.toString());
            }
        }
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("Worksheet".equals(qName)) {
            sheet = wb.createSheet(attributes.getValue("ss:Name"));
        } else if ("Row".equals(qName)) {
            row = sheet.createRow(sheet.getRow(0) == null ? 0 : sheet.getLastRowNum() + 1);
        } else if ("Cell".equals(qName)) {
            String index = attributes.getValue("ss:Index");
            cell = row.createCell(index != null ? Integer.valueOf(index) - 1 : row.getLastCellNum() == -1 ? 0 : row.getLastCellNum());
            String mergeAcross = attributes.getValue("ss:MergeAcross");
            String mergeDown = attributes.getValue("ss:MergeDown");
            if (mergeAcross != null || mergeDown != null) {
                int firstRow = row.getRowNum();
                int lastRow = mergeDown != null ? firstRow + Integer.valueOf(mergeDown) : firstRow;
                int firstCol = cell.getColumnIndex();
                int lastCol = mergeAcross != null ? firstCol + Integer.valueOf(mergeAcross) : firstCol;
                sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol));
            }
        } else if ("Data".equals(qName)) {
            String type = attributes.getValue("ss:Type");
            switch (type) {
                case "String":
                    this.type = CellType.STRING;
                    break;
                case "Number":
                    this.type = CellType.NUMERIC;
                    break;
                default:
                    this.type = CellType.STRING;
            }
            cell.setCellType(this.type);
            data = new StringBuilder();
        }

    }

}
