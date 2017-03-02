package com.eakonovalov.pattern.factorymethod;

/**
 * @author Waine
 * @version 1.0
 * @created 13-���-2017 15:57:19
 */
public class LoggerFactory {

    private static volatile LoggerFactory INSTANCE;

    protected LoggerFactory() {
    }

    public static LoggerFactory get() {
        if (INSTANCE == null) {
            synchronized (LoggerFactory.class) {
                if (INSTANCE == null) {
                    String className = System.getProperty("logger.factory.className");
                    try {
                        Class c = LoggerFactory.class.getClassLoader().loadClass(className);
                        INSTANCE = (LoggerFactory) c.newInstance();
                    } catch (NullPointerException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                        INSTANCE = new LoggerFactory();
                    }
                }
            }
        }

        return INSTANCE;
    }

    public Logger create() {
        return new DefaultLogger();
    }

}
