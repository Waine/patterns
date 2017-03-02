package com.eakonovalov.pattern.factorymethod;


/**
 * @author Waine
 * @version 1.0
 * @created 13-���-2017 16:07:36
 */
public class DefaultLogger implements Logger {

    protected DefaultLogger() {
    }

    public void log(String message) {
        System.out.println(this.getClass().getName() + ".log(" + message + ")");
    }

}
