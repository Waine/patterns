package com.eakonovalov.pattern.chainofresponsibility.impl;

import com.eakonovalov.pattern.chainofresponsibility.Handler;
import com.eakonovalov.pattern.chainofresponsibility.Request;
import com.eakonovalov.pattern.chainofresponsibility.Response;

/**
 * Created by Waine on 08.02.2017.
 */
public class CannotGiveExactAmountErrorHandler implements Handler {

    @Override
    public void handle(Request request, Response response) {
        if (request.getReminder() > 0) {
            throw new RuntimeException("Cannot give exact amount - " + request.getAmount());
        }
    }

    @Override
    public Handler addNext(Handler handler) {
        return null;
    }

}
