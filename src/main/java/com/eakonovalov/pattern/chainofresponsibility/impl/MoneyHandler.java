package com.eakonovalov.pattern.chainofresponsibility.impl;

import com.eakonovalov.pattern.chainofresponsibility.Request;
import com.eakonovalov.pattern.chainofresponsibility.Response;

/**
 * Created by Waine on 08.02.2017.
 */
public class MoneyHandler extends AbstractHandler {

    /**
     * Banknote face value
     */
    private int value;

    /**
     * Count of the banknotes
     */
    private int amount;

    public MoneyHandler(int value, int amount) {
        this.value = value;
        this.amount = amount;
    }

    @Override
    public void handle(Request request, Response response) {
        if (amount == 0) {
            if (getNext() != null) getNext().handle(request, response);
            return;
        }

        int count = (request.getReminder() - request.getReminder() % value) / value;

        if (count == 0) {
            if (getNext() != null) getNext().handle(request, response);
            return;
        }

        if (amount < count) {
            count = amount;
        }

        amount -= count;
        request.setReminder(request.getReminder() - count * value);
        response.getBanknotes().put(value, count);

        if (request.getReminder() > 0 && getNext() != null) getNext().handle(request, response);
    }

    public int getAmount() {
        return amount;
    }

    /**
     * @param amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getValue() {
        return value;
    }

    /**
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }

}
