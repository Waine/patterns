package com.eakonovalov.pattern.singleton;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Waine on 22.02.2017.
 */
public class SingletonTest {

    @Test
    public void get() throws Exception {
        TestThread t1 = new TestThread();
        TestThread t2 = new TestThread();

        t1.start();
        t2.start();

        assertTrue(t1.getSingleton() == t2.getSingleton());
    }

    private class TestThread extends Thread {

        private Singleton singleton;

        @Override
        public void run() {
            singleton = Singleton.get();
        }

        public Singleton getSingleton() {
            return singleton;
        }

        public void setSingleton(Singleton singleton) {
            this.singleton = singleton;
        }
    }

}