package com.eakonovalov.pattern.flyweight;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * Created by Waine on 15.02.2017.
 */
public class ThreadPool extends GenericObjectPool<ProcessingThread> {

    public ThreadPool(PooledObjectFactory<ProcessingThread> factory) {
        super(factory);
    }

    public ThreadPool(PooledObjectFactory<ProcessingThread> factory, GenericObjectPoolConfig config) {
        super(factory, config);
    }

}
