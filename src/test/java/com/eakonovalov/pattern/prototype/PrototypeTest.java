package com.eakonovalov.pattern.prototype;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Waine on 22.02.2017.
 */
public class PrototypeTest {

    @Test
    public void testClone() throws Exception {
        Prototype p = new Prototype();
        p.setProperty1("Hello world!");

        Prototype o = (Prototype) p.clone();

        assertTrue(p != o);
        assertEquals(p, o);

    }

}
