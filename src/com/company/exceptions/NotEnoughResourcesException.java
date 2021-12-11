package com.company.exceptions;

public class NotEnoughResourcesException extends RuntimeException {
    public NotEnoughResourcesException(int resourceNeeded, int resourcesExists) {
        super(String.format("Недостаточно ресурсов - ружно %d, имеется %d", resourceNeeded, resourcesExists));
    }
}
