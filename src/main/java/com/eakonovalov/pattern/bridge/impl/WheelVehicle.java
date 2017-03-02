package com.eakonovalov.pattern.bridge.impl;


import com.eakonovalov.pattern.bridge.Gear;
import com.eakonovalov.pattern.bridge.Vehicle;

/**
 * @author Waine
 * @version 1.0
 * @created 05-���-2017 13:17:56
 */
public abstract class WheelVehicle implements Vehicle {

    private Gear gear;

    public void handleGear() {
        gear.handleGear();
    }

    public Gear getGear() {
        return gear;
    }

    /**
     * @param gear
     */
    public void setGear(Gear gear) {
        this.gear = gear;
    }

    public void accelerate() {

    }

    public void brake() {

    }

    public void turnLeft() {

    }

    public void turnRight() {

    }

}
