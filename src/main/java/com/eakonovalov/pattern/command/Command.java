package com.eakonovalov.pattern.command;


/**
 * @author Waine
 * @version 1.0
 * @created 09-Feb-2017 15:19:08
 */
public interface Command {

    void execute();

    void setDevice(Switchable device);
}