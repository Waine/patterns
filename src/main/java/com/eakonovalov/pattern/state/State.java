package com.eakonovalov.pattern.state;


/**
 * @author Waine
 * @version 1.0
 * @created 01-���-2017 1:19:36
 */
public interface State {

    /**
     * @param context
     */
    void doAction(Context context);

}