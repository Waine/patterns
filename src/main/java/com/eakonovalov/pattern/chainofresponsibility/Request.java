package com.eakonovalov.pattern.chainofresponsibility;

/**
 * @author Waine
 * @version 1.0
 * @created 08-���-2017 18:52:20
 */
public class Request {

    private int amount;

    private int reminder;

    public Request(int amount) {
        this.amount = amount;
        this.reminder = amount;
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

    public int getReminder() {
        return reminder;
    }

    public void setReminder(int reminder) {
        this.reminder = reminder;
    }

}
