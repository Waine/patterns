package com.eakonovalov.pattern.nullobject;


/**
 * @author Waine
 * @version 1.0
 * @created 16-���-2017 22:47:00
 */
public class Client {

    private String name;
    private Address address;

    public Client() {

    }

    public Address getAddress() {
        return address;
    }

    /**
     * @param newVal
     */
    public void setAddress(Address newVal) {
        address = newVal;
    }

    public String getName() {
        return name;
    }

    /**
     * @param newVal
     */
    public void setName(String newVal) {
        name = newVal;
    }

}
