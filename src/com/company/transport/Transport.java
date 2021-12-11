package com.company.transport;

import com.company.IPositioned;
import com.company.Position;

import java.util.Objects;

public abstract class Transport implements IPositioned{
    protected Position position;
    private final String name;

    public Transport(Position startPosition, String transportName){
        position = startPosition;
        name = transportName;
    }

    @Override
    public Position getCoordinates() {
        return position;
    }

    public abstract void moveTo(IPositioned destination);

    @Override
    public String toString() {
        return "Transport{" +
                "position=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return Objects.equals(position, transport.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public String getName() {
        return name;
    }
}
