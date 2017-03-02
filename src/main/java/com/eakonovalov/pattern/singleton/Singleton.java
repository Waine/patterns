package com.eakonovalov.pattern.singleton;

/**
 * @author Waine
 * @version 1.0
 * @created 13-���-2017 15:57:19
 */
public class Singleton {

    private static volatile Singleton INSTANCE;

    private String property;

    private Singleton() {
    }

    public static Singleton get() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    Singleton temp = new Singleton();
                    temp.setProperty("Hello world!");
                    INSTANCE = temp;
                }
            }
        }

        return INSTANCE;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

}
