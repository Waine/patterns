package com.eakonovalov.pattern.chainofresponsibility.impl;

import com.eakonovalov.pattern.chainofresponsibility.Request;
import com.eakonovalov.pattern.chainofresponsibility.Response;

/**
 * Created by Waine on 08.02.2017.
 */
public class TooManyBanknotesErrorHandler extends AbstractHandler {

    private int threshold;

    public TooManyBanknotesErrorHandler(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public void handle(Request request, Response response) {
        if (getNext() != null) getNext().handle(request, response);

        int[] amount = {0};
        response.getBanknotes().forEach((k, v) -> amount[0] += v);

        if (amount[0] > threshold) {
            throw new RuntimeException("Too many banknotes - " + amount[0]);
        }
    }

}
