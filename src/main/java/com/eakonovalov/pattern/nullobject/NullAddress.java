package com.eakonovalov.pattern.nullobject;


/**
 * @author Waine
 * @version 1.0
 * @created 16-Feb-2017 22:47:01
 */
public class NullAddress extends Address {

    public static final Address INSTANCE = new NullAddress();

    private NullAddress() {
        super.setCity("");
        super.setCountry("");
        super.setStreet("");
        super.setZip("");
    }

    @Override
    public void setCity(String newVal) {
    }

    @Override
    public void setCountry(String newVal) {
    }

    @Override
    public void setStreet(String newVal) {
    }

    @Override
    public void setZip(String newVal) {
    }

}