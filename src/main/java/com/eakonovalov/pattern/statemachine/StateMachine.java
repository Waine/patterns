package com.eakonovalov.pattern.statemachine;

import java.util.Collection;

/**
 * @author Waine
 * @version 1.0
 * @created 01-Feb-2017 23:21:33
 */
public interface StateMachine {

    /**
     * @param values
     */
    void apply(Collection<String> values);

    /**
     * @param values
     */
    void apply(String... values);

    /**
     *
     */
    State getCurrent();

    /**
     * @param values
     */
    State getNext(Collection<String> values);

    /**
     * @param values
     */
    State getNext(String... values);

}
