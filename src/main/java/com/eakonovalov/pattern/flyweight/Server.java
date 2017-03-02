package com.eakonovalov.pattern.flyweight;

import org.apache.commons.io.IOUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Waine on 15.02.2017.
 */
public class Server extends Thread implements ProcessingThreadListener, InputStreamListener {

    public static final byte EOT = 4;
    private final Object lock = 0;
    protected Queue<InputStream> connections = new ConcurrentLinkedQueue<>();
    protected Queue<InputStream> awaiting = new ConcurrentLinkedQueue<>();
    protected ThreadPool threadPool;
    private volatile boolean alive = true;

    public Server() {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxIdle(20);
        config.setMaxTotal(20);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        threadPool = new ThreadPool(new ThreadFactory(), config);

        start();
    }

    public OutputStream getConnection() throws IOException {
        PipedInputStream pis = new PipedInputStream();
        pis.setInputStreamListener(this);
        connections.add(pis);

        return new PipedOutputStream(pis);
    }

    @Override
    public void run() {
        while (alive) {
            if (awaiting.size() == 0) {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        alive = false;
                    }
                }
            }

            for (InputStream is : awaiting) {
                try {
                    ProcessingThread t = threadPool.borrowObject();
                    t.process(awaiting.poll(), this);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void onFinish(InputStream is, ProcessingThread t) {
        threadPool.returnObject(t);
    }

    @Override
    public void onEOF(InputStream is, ProcessingThread t) {
        connections.remove(is);
        IOUtils.closeQuietly(is);
        threadPool.returnObject(t);
    }

    public void shutdown() {
        threadPool.close();
        for (InputStream is : connections) {
            IOUtils.closeQuietly(is);
        }
        connections.clear();
        alive = false;
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    @Override
    public void onReceived(InputStream is, int len) {
        if (!awaiting.contains(is)) {
            awaiting.add(is);
        }

        synchronized (lock) {
            lock.notifyAll();
        }
    }

}
