package com.eakonovalov.pattern.nullobject;


/**
 * @author Waine
 * @version 1.0
 * @created 16-���-2017 22:46:58
 */
public class Address {

    private String city;
    private String country;
    private String street;
    private String zip;

    public Address() {

    }

    public String getCity() {
        return city;
    }

    /**
     * @param newVal
     */
    public void setCity(String newVal) {
        city = newVal;
    }

    public String getCountry() {
        return country;
    }

    /**
     * @param newVal
     */
    public void setCountry(String newVal) {
        country = newVal;
    }

    public String getStreet() {
        return street;
    }

    /**
     * @param newVal
     */
    public void setStreet(String newVal) {
        street = newVal;
    }

    public String getZip() {
        return zip;
    }

    /**
     * @param newVal
     */
    public void setZip(String newVal) {
        zip = newVal;
    }

}