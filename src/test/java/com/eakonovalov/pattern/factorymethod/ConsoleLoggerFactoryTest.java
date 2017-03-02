package com.eakonovalov.pattern.factorymethod;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Waine on 13.02.2017.
 */
@RunWith(SeparateClassloaderTestRunner.class)
public class ConsoleLoggerFactoryTest {

    @Test
    public void testConsoleLogger() throws Exception {
        System.setProperty("logger.factory.className", "com.eakonovalov.pattern.factorymethod.console.Singleton");
        LoggerFactory.get().create().log("Test");
    }

}
