package com.eakonovalov.pattern.privatedataclass;

/**
 * Created by Waine on 22.02.2017.
 */
public class ExposesInternalState {

    private String property1;
    private String property2;

    public ExposesInternalState(String property1, String property2) {
        this.property1 = property1;
        this.property2 = property2;
    }

    public String concat() {
        return property1 + property2;
    }

    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    public String getProperty2() {
        return property2;
    }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }

}
