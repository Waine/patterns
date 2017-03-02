package com.eakonovalov.pattern.statemachine;

import com.eakonovalov.pattern.statemachine.impl.SimpleCondition;
import com.eakonovalov.pattern.statemachine.impl.SimpleState;
import com.eakonovalov.pattern.statemachine.impl.SingleStateTransition;
import com.eakonovalov.pattern.statemachine.impl.StateMachineImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Waine on 02.02.2017.
 */
public class StateMachineTest {

    @Test
    public void test() {
        State one = new SimpleState("one");
        State two = new SimpleState("two");
        State three = new SimpleState("three");

        Condition sunday = new SimpleCondition("Sunday");
        Condition raining = new SimpleCondition("Raining");
        Condition notSunday = new SimpleCondition("Not Sunday");
        Condition notRaining = new SimpleCondition("Not Raining");

        List<Transition> transitions = new ArrayList<>();
        transitions.add(new SingleStateTransition(one, three, sunday));
        transitions.add(new SingleStateTransition(one, two, sunday)); // <<--- Invalid, cant go to two and three
        transitions.add(new SingleStateTransition(one, three, raining));
        transitions.add(new SingleStateTransition(one, three, sunday, raining));
        transitions.add(new SingleStateTransition(one, three, notSunday, notRaining));

        StateMachine machine = new StateMachineImpl(one, transitions);
        assertEquals(one, machine.getCurrent());
        machine.apply("Sunday", "Raining");
        assertEquals(three, machine.getCurrent());
    }

}
