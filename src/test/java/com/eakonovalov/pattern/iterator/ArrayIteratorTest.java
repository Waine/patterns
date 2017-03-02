package com.eakonovalov.pattern.iterator;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

/**
 * Created by Waine on 16.02.2017.
 */
public class ArrayIteratorTest {

    @Test
    public void testFullIterate() throws Exception {
        Iterator<Byte> itr = new ArrayIterator<>(new Byte[128]);
        final int[] i = new int[1];
        itr.forEachRemaining(value -> i[0]++);

        assertEquals(128, i[0]);
    }

    @Test
    public void testPartialIterate() throws Exception {
        Iterator<Byte> itr = new ArrayIterator<>(new Byte[128], 5, 10);
        final int[] i = new int[1];
        itr.forEachRemaining(value -> i[0]++);

        assertEquals(5, i[0]);
    }

}
