package com.eakonovalov.pattern.adapter;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Waine
 * @version 1.0
 * @created 04-���-2017 0:56:08
 */
public class SSMLWorkbook extends XSSFWorkbook {

    public SSMLWorkbook(InputStream is) throws IOException, SAXException {
        SAXParserFactory parserFactor = SAXParserFactory.newInstance();
        SAXParser parser;
        try {
            parser = parserFactor.newSAXParser();
        } catch (ParserConfigurationException e) {
            throw new SAXException(e);
        }
        parser.parse(is, new SSMLHandler(this));
    }

    public SSMLWorkbook(File file) throws IOException, SAXException {
        this(new FileInputStream(file));
    }

    public SSMLWorkbook(String path) throws IOException, SAXException {
        this(new File(path));
    }

}
