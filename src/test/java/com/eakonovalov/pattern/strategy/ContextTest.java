package com.eakonovalov.pattern.strategy;

import org.junit.Test;

import static com.eakonovalov.pattern.strategy.StrategyType.GROOVY;
import static com.eakonovalov.pattern.strategy.StrategyType.JAVA;
import static org.junit.Assert.*;


/**
 * Created by Waine on 26.02.2017.
 */
public class ContextTest {

    @Test
    public void testStrategy() throws Exception {
        Context c = new Context(JAVA);
        assertEquals(0, c.getValue());
        c = new Context(GROOVY);
        assertEquals(1, c.getValue());
    }

}
