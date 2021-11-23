package com.company.transport;

import com.company.Position;
import com.company.LimitedStore;
import com.company.entities.Midget;

import java.util.Objects;

public abstract class PassengerTransport extends Transport{

    LimitedStore<Midget> passengers;

    public PassengerTransport(Position startPosition, int placesCount){
        super(startPosition);
        passengers = new LimitedStore<>(placesCount);
    }

    public void addPassenger(Midget passenger){
        passengers.add(passenger);
    }

    public void removePassenger(Midget passenger){
        passengers.remove(passenger);
    }

    public int countFreePlaces(){
        return passengers.countFreeCells();
    }

    @Override
    public String toString() {
        return "PassengerTransport{" +
                "position=" + position +
                ", freePlaces=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PassengerTransport that = (PassengerTransport) o;
        return Objects.equals(passengers, that.passengers) && Objects.equals(getCoordinates(), that.getCoordinates());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengers, getCoordinates());
    }
}
