package com.eakonovalov.pattern.statemachine.impl;

import com.eakonovalov.pattern.statemachine.State;
import com.eakonovalov.pattern.statemachine.StateMachine;
import com.eakonovalov.pattern.statemachine.Transition;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Waine
 * @version 1.0
 * @created 01-Feb-2017 23:21:37
 */
public class StateMachineImpl implements StateMachine {

    private State current;
    private Collection<Transition> transitions;

    public StateMachineImpl(State current, Collection<Transition> transitions) {
        this.current = current;
        this.transitions = transitions;
    }

    /**
     * @param values
     */
    public void apply(Collection<String> values) {
        current = getNext(values);
    }

    @Override
    public void apply(String... values) {
        apply(Arrays.asList(values));
    }

    @Override
    public State getCurrent() {
        return current;
    }

    /**
     * @param values
     */
    public State getNext(Collection<String> values) {
        for (Transition transition : transitions) {
            boolean currentStateMatches = transition.matches(current);
            boolean conditionsMatch = transition.meets(values);
            if (currentStateMatches && conditionsMatch) {
                return transition.target();
            }
        }
        return null;
    }

    @Override
    public State getNext(String... values) {
        return getNext(Arrays.asList(values));
    }

}
