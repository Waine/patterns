package com.eakonovalov.pattern.objectpool;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * @author Waine
 * @version 1.0
 * @created 21-Feb-2017 22:09:22
 */
public class ThreadPool extends GenericObjectPool<ProcessingThread> {

    public ThreadPool(PooledObjectFactory<ProcessingThread> factory) {
        super(factory);
    }

    public ThreadPool(PooledObjectFactory<ProcessingThread> factory, GenericObjectPoolConfig config) {
        super(factory, config);
    }

}
