package com.eakonovalov.pattern.statemachine.impl;

import com.eakonovalov.pattern.statemachine.Condition;
import com.eakonovalov.pattern.statemachine.State;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * @author Waine
 * @version 1.0
 * @created 01-Feb-2017 22:41:53
 */
public class SingleStateTransition extends AbstractStateTransition {

    private State from;

    public SingleStateTransition() {
    }

    public SingleStateTransition(State from, State to, Collection<Condition> conditions) {
        super(conditions, to);
        this.from = from;
    }

    public SingleStateTransition(State from, State to, Condition... conditions) {
        super(new HashSet<>(Arrays.asList(conditions)), to);
        this.from = from;
    }

    /**
     * @param state
     */
    public boolean matches(State state) {
        return from.equals(state);
    }

    public State getFrom() {
        return from;
    }

    public void setFrom(State from) {
        this.from = from;
    }

}
