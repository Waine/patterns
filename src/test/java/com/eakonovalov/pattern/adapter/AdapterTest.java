package com.eakonovalov.pattern.adapter;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Waine on 04.02.2017.
 */
public class AdapterTest {

    @Test
    public void testParse() throws Exception {
        Workbook wb = new SSMLWorkbook(this.getClass().getResourceAsStream("20101108.xml"));

        Sheet sheet = wb.getSheetAt(0);
        assertEquals(7, sheet.getLastRowNum());
        assertEquals(68, sheet.getRow(0).getLastCellNum());
        assertEquals(0d, sheet.getRow(1).getCell(0).getNumericCellValue(), 0);
        assertEquals("IRD_V_AMS_EUR", sheet.getRow(1).getCell(4).getStringCellValue());
    }

}
