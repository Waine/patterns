package com.eakonovalov.pattern.objectpool;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;

import java.util.NoSuchElementException;

/**
 * Created by Waine on 21.02.2017.
 */
public class ThreadPoolTest {

    @Test(expected = NoSuchElementException.class)
    public void test() throws Exception {

        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxIdle(2);
        config.setMaxTotal(2);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        ThreadPool threadPool = new ThreadPool(new ThreadFactory(), config);

        Thread t = threadPool.borrowObject();
        Thread t2 = threadPool.borrowObject();
        Thread t3 = threadPool.borrowObject(100);

    }

}
