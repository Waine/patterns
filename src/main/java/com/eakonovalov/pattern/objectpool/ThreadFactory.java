package com.eakonovalov.pattern.objectpool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/**
 * @author Waine
 * @version 1.0
 * @created 21-Feb-2017 22:09:19
 */
public class ThreadFactory extends BasePooledObjectFactory<ProcessingThread> {

    @Override
    public ProcessingThread create() throws Exception {
        ProcessingThread t = new ProcessingThread();
        t.setDaemon(true);
        t.start();
        return t;
    }

    @Override
    public PooledObject<ProcessingThread> wrap(ProcessingThread processingThread) {
        return new DefaultPooledObject<>(processingThread);
    }

    @Override
    public void passivateObject(PooledObject<ProcessingThread> pooledObject) throws Exception {
    }

    @Override
    public boolean validateObject(PooledObject<ProcessingThread> pooledObject) {
        return pooledObject.getObject().isAlive();
    }

    @Override
    public void destroyObject(PooledObject<ProcessingThread> p) throws Exception {
        p.getObject().shutdown();
    }

}