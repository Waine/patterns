package com.eakonovalov.pattern.prototype;

/**
 * Created by Waine on 22.02.2017.
 */
public class Prototype implements Cloneable {

    private String property1;

    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Prototype prototype = (Prototype) o;

        return property1 != null ? property1.equals(prototype.property1) : prototype.property1 == null;
    }

    @Override
    public int hashCode() {
        return property1 != null ? property1.hashCode() : 0;
    }

}
