package com.eakonovalov.pattern.objectpool;

/**
 * @author Waine
 * @version 1.0
 * @created 14-���-2017 14:24:05
 */
public class ProcessingThread extends Thread {

    private final byte[] buf = new byte[1024];
    private volatile boolean alive = true;

    @Override
    public void run() {
        while (alive) {
            synchronized (buf) {
                try {
                    buf.wait();
                } catch (InterruptedException e) {
                    alive = false;
                }
            }
        }
    }

    public void shutdown() {
        this.alive = false;
    }

}
