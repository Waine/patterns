package com.eakonovalov.pattern.composite;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Waine on 09.02.2017.
 */
public class CompositeTest {

    @Test
    public void test() throws Exception {
        Component c = new Container();
        Button b = new Button();
        Label l = new Label();
        c.add(b);
        c.add(l);

        assertTrue(c.isVisible());
        assertTrue(b.isVisible());
        assertTrue(l.isVisible());

        c.hide();

        assertTrue(!c.isVisible());
        assertTrue(!b.isVisible());
        assertTrue(!l.isVisible());

        b.show();

        assertTrue(!b.isVisible());

        c.show();

        assertTrue(b.isVisible());

        b.hide();

        assertTrue(!b.isVisible());
    }

}
