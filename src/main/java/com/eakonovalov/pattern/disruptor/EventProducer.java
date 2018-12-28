package com.eakonovalov.pattern.disruptor;

import com.lmax.disruptor.RingBuffer;

public interface EventProducer {

    void startProducing(final RingBuffer<ValueEvent> ringBuffer, final int count);

}
