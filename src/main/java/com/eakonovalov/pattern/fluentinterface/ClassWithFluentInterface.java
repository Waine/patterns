package com.eakonovalov.pattern.fluentinterface;


/**
 * @author Waine
 * @version 1.0
 * @created 06-���-2017 15:02:44
 */
public class ClassWithFluentInterface {

    private String property1;
    private int property2;
    private boolean property3;

    public String concat() {
        return property1 + property2 + property3;
    }

    /**
     * @param value
     */
    public ClassWithFluentInterface setProperty1(String value) {
        property1 = value;
        return this;
    }

    /**
     * @param value
     */
    public ClassWithFluentInterface setProperty2(int value) {
        property2 = value;
        return this;
    }

    /**
     * @param value
     */
    public ClassWithFluentInterface setProperty3(boolean value) {
        property3 = value;
        return this;
    }

}
