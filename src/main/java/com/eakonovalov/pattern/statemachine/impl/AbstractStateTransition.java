package com.eakonovalov.pattern.statemachine.impl;

import com.eakonovalov.pattern.statemachine.Condition;
import com.eakonovalov.pattern.statemachine.State;
import com.eakonovalov.pattern.statemachine.Transition;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Waine on 01.02.2017.
 */
public abstract class AbstractStateTransition implements Transition {

    private Collection<Condition> conditions;
    private State target;
    private State to;

    public AbstractStateTransition() {
    }

    public AbstractStateTransition(Collection<Condition> conditions, State target) {
        this.conditions = conditions;
        this.target = target;
    }


    public boolean meets(String... values) {
        return meets(Arrays.asList(values));
    }

    public boolean meets(Collection<String> values) {
        outer:
        for (String v : values) {
            for (Condition c : conditions) {
                if (c.meets(v)) {
                    continue outer;
                }
            }
            return false;
        }

        return true;
    }

    /**
     *
     */
    public State target() {
        return target;
    }

    public Collection<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(Collection<Condition> conditions) {
        this.conditions = conditions;
    }

    public State getTarget() {
        return target;
    }

    public void setTarget(State target) {
        this.target = target;
    }

    /**
     * @param state state
     */
    public boolean matches(State state) {
        return false;
    }

}
