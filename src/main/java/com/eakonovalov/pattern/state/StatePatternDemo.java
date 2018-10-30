package com.eakonovalov.pattern.state;


/**
 * @author Waine
 * @version 1.0
 * @created 01-Feb-2017 1:19:36
 */
public class StatePatternDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new StartState());

        System.out.println("Current state - " + context.getState());
        context.doAction();
        System.out.println("Current state - " + context.getState());
        context.doAction();
        System.out.println("Current state - " + context.getState());

    }

}
