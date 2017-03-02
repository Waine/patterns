package com.eakonovalov.pattern.command;


/**
 * @author Waine
 * @version 1.0
 * @created 09-���-2017 15:19:39
 */
public class RemoteControl {

    private Switchable device;

    /**
     * @param command
     */
    public void execute(Command command) {
        if (command != null) {
            command.setDevice(device);
            command.execute();
        }
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
