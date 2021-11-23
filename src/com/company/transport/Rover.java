package com.company.transport;

import com.company.IPositioned;
import com.company.Position;
import com.company.resources.interactors.ResourceStorage;
import com.company.resources.interactors.Trunk;

public class Rover extends PassengerTransport {
    private final Trunk trunk;

    public Rover(Position startPosition, int placesCount) {
        super(startPosition, placesCount);
        trunk = new Trunk();
    }

    public ResourceStorage getStorage(){
        return trunk;
    }

    @Override
    public void moveTo(IPositioned destination) {
        System.out.printf("Еду в точку %s", destination.getCoordinates().toString());
        position = destination.getCoordinates();
        System.out.printf("Достиг точки %s", position.toString());
    }
}
