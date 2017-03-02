package com.eakonovalov.pattern.facade;

import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Waine on 12.02.2017.
 */
public class SheetHandler extends DefaultHandler {

    private SharedStringsTable sst;
    private StringBuilder content;
    private boolean nextIsString;
    private boolean nextIsInlineString;

    public SheetHandler(SharedStringsTable sst) {
        this.sst = sst;
    }

    public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
        if (name.equals("c")) {
            System.out.print(attributes.getValue("r") + " - ");
            String cellType = attributes.getValue("t");
            nextIsString = false;
            if (cellType != null) {
                nextIsString = cellType.equals("s");
                nextIsInlineString = cellType.equals("inlineStr");
            }
        } else if (name.equals("v") || name.equals("t")) {
            content = new StringBuilder();
        }
    }

    public void endElement(String uri, String localName, String name) throws SAXException {
        if (name.equals("v")) {
            if (nextIsString) {
                int idx = Integer.parseInt(content.toString());
                String value = new XSSFRichTextString(sst.getEntryAt(idx)).toString();
                System.out.println(value);
                nextIsString = false;
            }
        } else if (name.equals("t")) {
            if (nextIsInlineString) {
                String value = new XSSFRichTextString(content.toString()).toString();
                System.out.println(value);
                nextIsInlineString = false;
            }
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        content.append(ch, start, length);
    }

}
