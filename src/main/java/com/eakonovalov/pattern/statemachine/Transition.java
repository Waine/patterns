package com.eakonovalov.pattern.statemachine;


import java.util.Collection;

/**
 * @author Waine
 * @version 1.0
 * @created 01-���-2017 22:42:04
 */
public interface Transition {

    /**
     * @param state
     */
    boolean matches(State state);

    /**
     * @param values
     */
    boolean meets(Collection<String> values);

    /**
     * @param values
     */
    boolean meets(String... values);

    /**
     *
     */
    State target();

}
