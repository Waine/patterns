package com.eakonovalov.pattern.command.impl;

import com.eakonovalov.pattern.command.Switchable;

/**
 * Created by Waine on 09.02.2017.
 */
public class Device implements Switchable {

    private boolean on = false;

    public void off() {
        on = false;
    }

    public void on() {
        on = true;
    }

    public boolean isOn() {
        return on;
    }

}
