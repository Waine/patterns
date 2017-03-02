package com.eakonovalov.pattern.chainofresponsibility.impl;

import com.eakonovalov.pattern.chainofresponsibility.Handler;

/**
 * Created by Waine on 08.02.2017.
 */
public abstract class AbstractHandler implements Handler {

    private Handler next;

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    /**
     * @param handler
     */
    public Handler addNext(Handler handler) {
        if (next != null) {
            return next.addNext(handler);
        } else {
            next = handler;
            return next;
        }
    }

}
