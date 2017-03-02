package com.eakonovalov.pattern.observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * Created by Waine on 22.02.2017.
 */
@Component
public class JmsProducer {

    private JmsTemplate jmsTemplate;
    private Destination destination;

    @Autowired
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Autowired
    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public void sendMessage(final String msg) {
        jmsTemplate.send(destination, session -> session.createTextMessage(msg));
    }

}
