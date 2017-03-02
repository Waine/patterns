package com.eakonovalov.pattern.state;


/**
 * @author Waine
 * @version 1.0
 * @created 01-���-2017 1:19:36
 */
public class Context {

    private State state;

    public void doAction() {
        state.doAction(this);
    }

    public State getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(State state) {
        this.state = state;
    }

}
