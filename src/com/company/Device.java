package com.company;

import com.company.transport.Transport;

import java.util.Objects;

public abstract class Device {
    
    public abstract void turnOn();
    public abstract void turnOff();
    
    public abstract String describe();

    @Override
    public String toString() {
        return "Device{description=" + describe() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return describe().equals(device.describe());
    }

    @Override
    public int hashCode() { return Objects.hash(describe()); }

}
