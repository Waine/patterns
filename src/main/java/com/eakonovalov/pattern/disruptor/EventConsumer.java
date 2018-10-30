package com.eakonovalov.pattern.disruptor;

import com.lmax.disruptor.EventHandler;

public interface EventConsumer {

    EventHandler<ValueEvent>[] getEventHandler();

}
