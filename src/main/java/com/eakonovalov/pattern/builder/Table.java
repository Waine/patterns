package com.eakonovalov.pattern.builder;


import java.util.List;

/**
 * @author Waine
 * @version 1.0
 * @created 06-Feb-2017 16:05:18
 */
public interface Table {

    List<String> addRow();

    /**
     * @param index
     */
    List<String> addRow(int index);

    /**
     * @param index
     */
    List<String> getRow(int index);

    /**
     * @param row
     * @param col
     */
    String getValue(int row, int col);

    /**
     * @param index
     */
    List<String> removeRow(int index);

    /**
     * @param row
     * @param col
     * @param value
     */
    void setValue(int row, int col, String value);

    int getRowCount();

    int getColumnCount();

    void save();

}
