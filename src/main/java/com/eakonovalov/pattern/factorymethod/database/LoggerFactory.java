package com.eakonovalov.pattern.factorymethod.database;

/**
 * @author Waine
 * @version 1.0
 * @created 13-Feb-2017 16:40:10
 */
public class LoggerFactory extends com.eakonovalov.pattern.factorymethod.LoggerFactory {

    public LoggerFactory() {

    }

    public Logger create() {
        return new Logger();
    }

}
