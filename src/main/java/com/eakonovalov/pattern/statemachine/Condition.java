package com.eakonovalov.pattern.statemachine;


/**
 * @author Waine
 * @version 1.0
 * @created 01-Feb-2017 22:41:33
 */
public interface Condition {

    /**
     * @param value
     */
    boolean meets(String value);

}
