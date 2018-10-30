package com.eakonovalov.pattern.statemachine.impl;

import com.eakonovalov.pattern.statemachine.State;

/**
 * @author Waine
 * @version 1.0
 * @created 01-Feb-2017 23:02:26
 */
public class SimpleState implements State {

    private String code;

    public SimpleState() {
    }

    public SimpleState(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleState that = (SimpleState) o;

        return code != null ? code.equals(that.code) : that.code == null;
    }

    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
    }

}
