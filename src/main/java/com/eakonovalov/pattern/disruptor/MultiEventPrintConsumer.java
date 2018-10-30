package com.eakonovalov.pattern.disruptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmax.disruptor.EventHandler;

public class MultiEventPrintConsumer implements EventConsumer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    @SuppressWarnings("unchecked")
    public EventHandler<ValueEvent>[] getEventHandler() {
        final EventHandler<ValueEvent> eventHandler = (event, sequence, endOfBatch) -> print("eventHandler", event.getValue(), sequence);
        final EventHandler<ValueEvent> otherEventHandler = (event, sequence, endOfBatch) -> print("otherEventHandler", event.getValue(), sequence);
        return new EventHandler[] { eventHandler, otherEventHandler };
    }

    private void print(String name, final int id, final long sequenceId) {
        logger.info(name + " - Id is " + id + " sequence id that was used is " + sequenceId);
    }

}
