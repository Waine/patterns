package com.eakonovalov.pattern.visitor;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Waine on 28.02.2017.
 */
public class SumVisitorTest {

    @Test
    public void testVisit() throws Exception {
        SumVisitor v = new SumVisitor();

        Collection<Object> c = new ArrayList<>();
        c.add(Arrays.asList(1, 2, 3));
        c.add(1);
        c.add(1.1d);
        c.add(1.2f);

        c.forEach(v::visit);

        assertEquals(9, v.getResult());
    }

}
