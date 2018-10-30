package com.eakonovalov.pattern.statemachine.impl;

import com.eakonovalov.pattern.statemachine.Condition;

/**
 * @author Waine
 * @version 1.0
 * @created 01-Feb-2017 22:41:51
 */
public class SimpleCondition implements Condition {

    private String value;

    public SimpleCondition() {
    }

    public SimpleCondition(String value) {
        this.value = value;
    }

    /**
     * @param value
     */
    public boolean meets(String value) {
        return this.value.equals(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
