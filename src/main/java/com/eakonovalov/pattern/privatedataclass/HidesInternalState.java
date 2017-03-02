package com.eakonovalov.pattern.privatedataclass;

/**
 * Created by Waine on 22.02.2017.
 */
public class HidesInternalState {

    private PrivateDataClass data;

    public HidesInternalState(String property1, String property2) {
        data = new PrivateDataClass();
        data.setProperty1(property1);
        data.setProperty2(property2);
    }

    public String concat() {
        return data.getProperty1() + data.getProperty2();
    }

}
