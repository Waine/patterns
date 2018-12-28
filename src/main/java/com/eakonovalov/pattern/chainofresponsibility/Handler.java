package com.eakonovalov.pattern.chainofresponsibility;

/**
 * @author Waine
 * @version 1.0
 * @created 08-Feb-2017 18:52:00
 */
public interface Handler {

    /**
     * @param request
     * @param response
     */
    void handle(Request request, Response response);

    /**
     * @param handler
     */
    Handler addNext(Handler handler);

}
