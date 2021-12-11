package com.company.transport;

import com.company.IPositioned;
import com.company.Position;
import com.company.exceptions.TrunkNotOpenedException;
import com.company.resources.interactors.ResourceStorage;

public class Rover extends PassengerTransport {
    private final Trunk trunk;
    private final Door rDoor, lDoor;

    public Rover(Position startPosition, int placesCount, String transportName) {
        super(startPosition, placesCount, transportName);
        trunk = new Trunk();
        lDoor = new Door();
        rDoor = new Door();
    }

    public Trunk getTrunk(){
        return trunk;
    }

    @Override
    public void moveTo(IPositioned destination) {
        System.out.printf("Еду в точку %s\n", destination.getCoordinates().toString());
        position = destination.getCoordinates();
        System.out.printf("Достиг точки %s\n", position.toString());
    }

    public Door getRDoor() {
        return rDoor;
    }

    public Door getLDoor() {
        return lDoor;
    }

    public class Trunk{

        private final ResourceStorage storage;
        private boolean isOpened = false;

        public Trunk() {
            storage = new ResourceStorage(15);
        }

        public void open() {
            System.out.printf("Багаж автомобиля %s открыт\n", getName());
            isOpened = true;
        }

        public void close() {
            System.out.printf("Багаж автомобиля %s закрыт\n", getName());
            isOpened = false;
        }

        public ResourceStorage getStorage() throws TrunkNotOpenedException {
            if (!isOpened)
                throw new TrunkNotOpenedException();
            return storage;
        }
    }

    protected class Door {

        private boolean isOpened = false;

        public void open() {
            System.out.printf("Дверь автомобиля %s открыта\n", getName());
            isOpened = true;
        }

        public void close() {
            System.out.printf("Дверь автомобиля %s закрыта\n", getName());
            isOpened = false;
        }
    }

}
