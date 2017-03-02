package com.eakonovalov.pattern.statemachine.impl;

import com.eakonovalov.pattern.statemachine.Condition;

/**
 * @author Waine
 * @version 1.0
 * @created 01-���-2017 22:41:49
 */
public class RegexCondition implements Condition {

    private String regex;

    public RegexCondition() {
    }

    public RegexCondition(String regex) {
        this.regex = regex;
    }

    /**
     * @param value
     */
    public boolean meets(String value) {
        return value.matches(regex);
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

}
