package com.eakonovalov.pattern.builder.impl;

import com.eakonovalov.pattern.builder.Table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Waine
 * @version 1.0
 * @created 06-���-2017 16:26:18
 */
public abstract class TableImpl implements Table {

    private String fileName;

    private List<List<String>> table = new ArrayList<>();

    public TableImpl() {
    }

    public TableImpl(String fileName) {
        this.fileName = fileName;
    }

    public List<String> addRow() {
        table.add(new ArrayList<>());
        return Collections.unmodifiableList(table.get(table.size() - 1));
    }

    /**
     * @param index
     */
    public List<String> addRow(int index) {
        List<String> row = new ArrayList<>();
        table.add(index, row);
        return Collections.unmodifiableList(row);
    }

    /**
     * @param index
     */
    public List<String> getRow(int index) {
        return Collections.unmodifiableList(table.get(index));
    }

    /**
     * @param row
     * @param col
     */
    public String getValue(int row, int col) {
        return table.get(row).get(col);
    }

    /**
     * @param index
     */
    public List<String> removeRow(int index) {
        return table.remove(index);
    }

    /**
     * @param row
     * @param col
     * @param value
     */
    public void setValue(int row, int col, String value) {
        if (row >= table.size()) {
            int diff = row - table.size();
            for (int i = 0; i <= diff; i++) {
                addRow();
            }
        }
        if (col >= getRow(0).size()) {
            for (List<String> r : table) {
                int diff = col - r.size();
                for (int i = 0; i <= diff; i++) {
                    r.add("");
                }
            }
        }

        List<String> r = table.get(row);
        r.remove(col);
        r.add(col, value);
    }

    @Override
    public int getRowCount() {
        return table.size();
    }

    @Override
    public int getColumnCount() {
        if (table.size() > 0) {
            return table.get(0).size();
        }
        return 0;
    }

    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public abstract void save();

}
