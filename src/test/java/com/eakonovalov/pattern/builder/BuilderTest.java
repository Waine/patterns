package com.eakonovalov.pattern.builder;

import com.eakonovalov.pattern.builder.impl.TableImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Waine on 06.02.2017.
 */
public class BuilderTest {

    private Table t;

    @Before
    public void setup() {
        t = new TableImpl("") {
            @Override
            public void save() {
            }
        };
    }

    @Test
    public void testAddRow() throws Exception {
        t.addRow();
        assertEquals(1, t.getRowCount());
        t.setValue(0, 0, "value");
        t.addRow(0);
        assertEquals("value", t.getValue(1, 0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetNonexistentValue() throws Exception {
        t.getValue(1, 1);
    }

    @Test
    public void testGetValue() throws Exception {
        t.setValue(0, 0, "value");
        t.getValue(0, 0);
        assertEquals("value", t.getValue(0, 0));
        assertEquals(1, t.getRowCount());
        assertEquals(1, t.getColumnCount());
    }

    @Test
    public void testRemoveRow() throws Exception {
        t.setValue(3, 4, "value");
        assertEquals("value", t.getValue(3, 4));
        t.removeRow(0);
        assertEquals("value", t.getValue(2, 4));
    }

    @Test
    public void testSetValue() throws Exception {
        t.setValue(1, 1, "value");
        assertEquals("value", t.getValue(1, 1));
        t.setValue(3, 4, "value2");
        assertEquals("value", t.getValue(1, 1));
        assertEquals("value2", t.getValue(3, 4));
        t.setValue(3, 4, "value3");
        assertEquals("value", t.getValue(1, 1));
        assertEquals("value3", t.getValue(3, 4));
        assertEquals(4, t.getRowCount());
        assertEquals(5, t.getColumnCount());
    }

}