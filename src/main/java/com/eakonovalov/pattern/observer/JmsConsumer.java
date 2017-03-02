package com.eakonovalov.pattern.observer;

/**
 * Created by Waine on 22.02.2017.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class JmsConsumer {

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

    public String receiveMessage() throws JMSException {
        return ((TextMessage) jmsTemplate.receive(destination)).getText();
    }

}
