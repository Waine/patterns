package com.eakonovalov.pattern.statemachine.impl;

import com.eakonovalov.pattern.statemachine.Condition;
import com.eakonovalov.pattern.statemachine.State;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * @author Waine
 * @version 1.0
 * @created 01-Feb-2017 22:42:32
 */
public class MultipleStateTransition extends AbstractStateTransition {

    private Collection<State> from;

    public MultipleStateTransition() {
    }

    public MultipleStateTransition(Collection<State> from, State to, Collection<Condition> conditions) {
        super(conditions, to);
        this.from = from;
    }

    public MultipleStateTransition(Collection<State> from, State to, Condition... conditions) {
        super(new HashSet<>(Arrays.asList(conditions)), to);
        this.from = from;
    }

    /**
     * @param state
     */
    public boolean matches(State state) {
        return from.contains(state);
    }

    public Collection<State> getFrom() {
        return from;
    }

    public void setFrom(Collection<State> from) {
        this.from = from;
    }

}
