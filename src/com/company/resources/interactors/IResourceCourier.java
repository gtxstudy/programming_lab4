package com.company.resources.interactors;

public interface IResourceCourier {
    void deliver(IResourceConsumer consumer, IResourceProvider provider);
}
