package com.eakonovalov.pattern.state;


/**
 * @author Waine
 * @version 1.0
 * @created 01-���-2017 1:19:36
 */
public class StartState extends AbstractState {

    public StartState() {
        super("Start");
    }

    /**
     * @param context
     */
    public void doAction(Context context) {
        context.setState(new EndState());
    }

}
