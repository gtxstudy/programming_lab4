package com.company;

public abstract class Device {
    
    public abstract void turnOn();
    public abstract void turnOff();
    
    public abstract String describe();

    @Override
    public String toString() {
        return "Device{description=" + describe() + "}";
    }
}
