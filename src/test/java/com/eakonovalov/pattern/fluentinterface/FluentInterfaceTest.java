package com.eakonovalov.pattern.fluentinterface;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Waine on 06.02.2017.
 */
public class FluentInterfaceTest {

    @Test
    public void concat() throws Exception {
        assertEquals("Property1true", new ClassWithFluentInterface()
                .setProperty1("Property")
                .setProperty2(1)
                .setProperty3(true)
                .concat());
    }

}