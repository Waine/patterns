package com.eakonovalov.pattern.disruptor;

import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.DaemonThreadFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ThreadFactory;

public class DisruptorIntegrationTest {
    private Disruptor<ValueEvent> disruptor;
    private WaitStrategy waitStrategy;

    @Before
    public void setUp() throws Exception {
        waitStrategy = new BusySpinWaitStrategy();
    }

    @After
    public void tearDown() throws Exception {
        disruptor.halt();
        disruptor.shutdown();
    }

    private void createDisruptor(final ProducerType producerType, final EventConsumer eventConsumer) {
        final ThreadFactory threadFactory = DaemonThreadFactory.INSTANCE;
        disruptor = new Disruptor<>(ValueEvent.EVENT_FACTORY, 16, threadFactory, producerType, waitStrategy);
        disruptor.handleEventsWith(eventConsumer.getEventHandler());
    }

    @Test
    public void whenMultipleProducerSingleConsumer_thenOutputInFifoOrder() throws Exception {
        createDisruptor(ProducerType.MULTI, new SingleEventPrintConsumer());
        final RingBuffer<ValueEvent> ringBuffer = disruptor.start();
        new DelayedMultiEventProducer().startProducing(ringBuffer, 32);

        Thread.sleep(10000);
    }

    @Test
    public void whenSingleProducerSingleConsumer_thenOutputInFifoOrder() throws Exception {
        createDisruptor(ProducerType.SINGLE, new SingleEventConsumer());
        final RingBuffer<ValueEvent> ringBuffer = disruptor.start();
        new SingleEventProducer().startProducing(ringBuffer, 32);

        Thread.sleep(10000);
    }

    @Test
    public void whenSingleProducerMultipleConsumer_thenOutputInFifoOrder() throws Exception {
        createDisruptor(ProducerType.SINGLE, new MultiEventConsumer());
        final RingBuffer<ValueEvent> ringBuffer = disruptor.start();
        new SingleEventProducer().startProducing(ringBuffer, 32);

        Thread.sleep(10000);
    }

    @Test
    public void whenMultipleProducerMultipleConsumer_thenOutputInFifoOrder() throws Exception {
        createDisruptor(ProducerType.MULTI, new MultiEventPrintConsumer());
        final RingBuffer<ValueEvent> ringBuffer = disruptor.start();
        new DelayedMultiEventProducer().startProducing(ringBuffer, 55);

        Thread.sleep(10000);
    }

}
