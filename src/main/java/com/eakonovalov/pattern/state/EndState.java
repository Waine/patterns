package com.eakonovalov.pattern.state;


/**
 * @author Waine
 * @version 1.0
 * @created 01-���-2017 1:19:36
 */
public class EndState extends AbstractState {

    public EndState() {
        super("End");
    }

    /**
     * @param context
     */
    public void doAction(Context context) {
        context.setState(new StartState());
    }

}
