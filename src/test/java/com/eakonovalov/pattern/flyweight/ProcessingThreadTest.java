package com.eakonovalov.pattern.flyweight;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Waine on 14.02.2017.
 */
public class ProcessingThreadTest {

    @Test
    public void testSingleWrite() throws Exception {
        Server s = new Server();
        Thread t = new WriterThread(s, 128);

        s.join(1000);

        s.shutdown();
    }

    @Test
    public void testDoubleWrite() throws Exception {
        Server s = new Server();
        Thread t = new WriterThread(s, 128);
        t.join();
        t = new WriterThread(s, 128);
        t.join();
        s.shutdown();
    }

    @Test
    public void testExceedBuffer() throws Exception {
        Server s = new Server();
        Thread t = new WriterThread(s, 1280000);
        t.join();

        Thread.sleep(1000);

        s.shutdown();
    }

    @Test
    public void run2Threads() throws Exception {
        Server s = new Server();

        Thread t = new WriterThread(s, 128000);
        Thread t2 = new WriterThread(s, 128000);

        t.join();
        t2.join();

        Thread.sleep(1000);

        s.shutdown();

    }

    @Test
    public void close() throws Exception {
        Server s = new Server();
        OutputStream os = s.getConnection();

        os.write(RandomStringUtils.random(128).getBytes());
        Thread.sleep(1000);
        os.write(RandomStringUtils.random(128).getBytes());
        os.close();
    }

    private static class WriterThread extends Thread {

        private Server s;
        private int len;

        public WriterThread(Server s, int len) {
            this.s = s;
            this.len = len;
            start();
        }

        @Override
        public void run() {
            try {
                OutputStream os = s.getConnection();
                byte[] data = RandomStringUtils.randomAlphanumeric(len).getBytes();
                for (int i = 0; i < 100; i++) {
                    os.write(data);
                }
                os.write(Server.EOT);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
