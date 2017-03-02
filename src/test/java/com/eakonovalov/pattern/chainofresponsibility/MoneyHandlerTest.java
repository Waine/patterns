package com.eakonovalov.pattern.chainofresponsibility;

import com.eakonovalov.pattern.chainofresponsibility.impl.CannotGiveExactAmountErrorHandler;
import com.eakonovalov.pattern.chainofresponsibility.impl.MoneyHandler;
import com.eakonovalov.pattern.chainofresponsibility.impl.TooManyBanknotesErrorHandler;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Waine on 08.02.2017.
 */
public class MoneyHandlerTest {

    private Handler handler;

    @Before
    public void setup() {
        handler = new TooManyBanknotesErrorHandler(20);
        handler.addNext(new MoneyHandler(100, 10))
                .addNext(new MoneyHandler(50, 10))
                .addNext(new MoneyHandler(20, 10))
                .addNext(new MoneyHandler(10, 10))
                .addNext(new MoneyHandler(5, 10))
                .addNext(new CannotGiveExactAmountErrorHandler());
    }

    @Test
    public void testHandle() {
        Request request = new Request(120);
        Response response = new Response();

        handler.handle(request, response);
        assertEquals(2, response.getBanknotes().size());
        assertEquals(1, response.getBanknotes().get(100).intValue());
        assertEquals(1, response.getBanknotes().get(20).intValue());
        assertEquals(120, request.getAmount());
        assertEquals(0, request.getReminder());
    }

    @Test(expected = RuntimeException.class)
    public void testCannotGiveExactAmountErrorBelowLowerLimit() {
        Request request = new Request(3);
        Response response = new Response();

        handler.handle(request, response);
    }

    @Test(expected = RuntimeException.class)
    public void testCannotGiveExactAmountErrorAboveUpperLimit() {
        Request request = new Request(1851);
        Response response = new Response();

        handler.handle(request, response);
    }

    @Test(expected = RuntimeException.class)
    public void testTooManyBanknotesError() {
        Request request = new Request(1510);
        Response response = new Response();

        handler.handle(request, response);
    }

}
