package com.eakonovalov.pattern.observer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.JMSException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Waine on 22.02.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "applicationContext.xml")
public class ObserverTest {

    private static final String MSG = "Hello world!";

    @Autowired
    private JmsProducer jmsProducer;

    @Autowired
    private JmsConsumer jmsConsumer;

    @Test
    public void test() throws InterruptedException {
        ConsumerThread t1 = new ConsumerThread();
        ConsumerThread t2 = new ConsumerThread();
        jmsProducer.sendMessage(MSG);
        t1.join();
        t2.join();

        assertEquals(MSG, t1.getMessage());
        assertEquals(MSG, t2.getMessage());
    }

    private class ConsumerThread extends Thread {

        private String message;

        public ConsumerThread() {
            start();
        }

        @Override
        public void run() {
            try {
                message = jmsConsumer.receiveMessage();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

        public String getMessage() {
            return message;
        }

    }

}
