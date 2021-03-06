package com.company.entities;

import com.company.exceptions.StorageIsEmptyException;
import com.company.resources.interactors.IResourceConsumer;
import com.company.resources.interactors.IResourceCourier;
import com.company.resources.interactors.IResourceProvider;
import com.company.resources.interactors.ResourceCourier;

public class Vintik extends Engineer implements IResourceCourier {

    public Vintik() {
        super(Gender.MALE, "Винтик");
    }

    @Override
    public void deliver(IResourceConsumer consumer, IResourceProvider provider) {
        try {
            ResourceCourier.deliver(consumer, provider);
        } catch (StorageIsEmptyException e) {
            e.printStackTrace();
        }
    }
}
