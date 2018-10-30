package com.eakonovalov.pattern.flyweight;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Waine
 * @version 1.0
 * @created 14-Feb-2017 14:24:05
 */
public class ProcessingThread extends Thread {

    private final byte[] buf = new byte[1024];
    private InputStream in;
    private ProcessingThreadListener listener;
    private volatile boolean alive = true;

    @Override
    public void run() {
        while (alive) {
            if (in == null) {
                synchronized (buf) {
                    try {
                        buf.wait();
                    } catch (InterruptedException e) {
                        alive = false;
                    }
                }
            }

            int len = -1;
            boolean eot = false;
            try {
                while (in != null && in.available() > 0 && (len = in.read(buf)) != -1) {
                    eot = (len % 2 != 0) && buf[len - 1] == Server.EOT;
                    if (eot) len--;
                    if (len > 0) System.out.println(getName() + " - " + new String(buf, 0, len));
                }
            } catch (IOException e) {
                alive = false;
            } finally {
                InputStream temp = in;
                in = null;
                if (eot) {
                    System.out.println(getName() + " - EOT");
                    listener.onEOF(temp, this);
                } else {
                    listener.onFinish(temp, this);
                }
            }
        }
    }

    public void process(InputStream in, ProcessingThreadListener l) {
        this.in = in;
        this.listener = l;
        synchronized (buf) {
            buf.notifyAll();
        }
    }

    public void shutdown() {
        this.alive = false;
    }

}
