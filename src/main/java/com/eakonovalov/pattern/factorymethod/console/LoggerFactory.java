package com.eakonovalov.pattern.factorymethod.console;

/**
 * @author Waine
 * @version 1.0
 * @created 13-���-2017 16:39:53
 */
public class LoggerFactory extends com.eakonovalov.pattern.factorymethod.LoggerFactory {

    public LoggerFactory() {

    }

    public Logger create() {
        return new Logger();
    }

}
