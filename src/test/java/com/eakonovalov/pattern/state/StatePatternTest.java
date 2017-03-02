package com.eakonovalov.pattern.state;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Waine on 02.02.2017.
 */
public class StatePatternTest {

    @Test
    public void test() {
        Context context = new Context();
        context.setState(new StartState());

        assertEquals(new StartState(), context.getState());
        context.doAction();
        assertEquals(new EndState(), context.getState());
        context.doAction();
        assertEquals(new StartState(), context.getState());

    }

}
