package com.eakonovalov.pattern.strategy;

import com.eakonovalov.pattern.strategy.impl.JavaStrategy;
import groovy.lang.GroovyClassLoader;
import org.apache.commons.io.IOUtils;

/**
 * @author Waine
 * @version 1.0
 * @created 26-Feb-2017 20:06:42
 */
public class Context {

    private Strategy strategy;

    public Context(StrategyType type) {
        switch (type) {
            case GROOVY:
                try {
                    String fileName = "GroovyStrategy.groovy";
                    String script = IOUtils.toString(this.getClass().getResourceAsStream(
                            "/com/eakonovalov/pattern/strategy/impl/" + fileName), "UTF-8");
                    GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
                    Class c = groovyClassLoader.parseClass(script, fileName);
                    this.strategy = (Strategy) c.newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case JAVA:
            default:
                this.strategy = new JavaStrategy();
        }
    }

    public int getValue() {
        return strategy.calculate();
    }

}
