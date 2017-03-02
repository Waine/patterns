package com.eakonovalov.pattern.command;


/**
 * @author Waine
 * @version 1.0
 * @created 09-���-2017 15:19:29
 */
public class OnCommand implements Command {

    private Switchable device;

    public void execute() {
        if (device != null) device.on();
    }

    public Switchable getDevice() {
        return device;
    }

    /**
     * @param device
     */
    public void setDevice(Switchable device) {
        this.device = device;
    }

}
