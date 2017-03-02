package com.eakonovalov.pattern.templatemethod;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.*;

/**
 * Created by Waine on 27.02.2017.
 */
public class WorkerThreadTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void test() throws Exception {
        Thread t = new WorkerThread();
        t.start();
        t.join();
        assertEquals("Hello world!", systemOutRule.getLog());
    }

}
