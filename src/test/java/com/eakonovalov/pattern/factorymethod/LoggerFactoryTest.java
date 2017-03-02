package com.eakonovalov.pattern.factorymethod;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Waine on 13.02.2017.
 */
@RunWith(SeparateClassloaderTestRunner.class)
public class LoggerFactoryTest {

    @Test
    public void testDefaultLogger() throws Exception {
        System.setProperty("logger.factory.className", "");
        LoggerFactory.get().create().log("Test");
    }

}
