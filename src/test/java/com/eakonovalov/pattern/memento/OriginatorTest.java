package com.eakonovalov.pattern.memento;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Waine on 20.02.2017.
 */
public class OriginatorTest {

    private Originator o;
    private Caretaker c;

    @Before
    public void init() {
        o = new Originator();
        c = new Caretaker();
    }

    @Test
    public void testSaveOnceUndoOnce() throws Exception {
        o.getContent().append("Aaa");
        c.save(o);
        o.getContent().append("Bbb");
        assertEquals("AaaBbb", o.toString());
        c.undo(o);
        assertEquals("Aaa", o.toString());
    }

    @Test
    public void testTwiceOnceUndoTwice() throws Exception {
        o.getContent().append("Aaa");
        c.save(o);
        o.getContent().append("Bbb");
        c.save(o);
        o.getContent().append("Ccc");
        assertEquals("AaaBbbCcc", o.toString());
        c.undo(o);
        assertEquals("AaaBbb", o.toString());
        c.undo(o);
        assertEquals("Aaa", o.toString());
    }

    @Test
    public void testSaveOnceUndoTwice() throws Exception {
        o.getContent().append("Aaa");
        c.save(o);
        o.getContent().append("Bbb");
        assertEquals("AaaBbb", o.toString());
        c.undo(o);
        assertEquals("Aaa", o.toString());
        c.undo(o);
        assertEquals("Aaa", o.toString());
    }

}
