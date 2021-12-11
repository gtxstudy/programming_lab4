package com.company.resources.interactors;

import com.company.LimitedStore;
import com.company.exceptions.StorageIsEmptyException;
import com.company.resources.Resource;

import java.util.Objects;

public class ResourceStorage implements IResourceProvider, IResourceConsumer {
    protected LimitedStore<Resource> store;

    public ResourceStorage(int capacity) {
        store = new LimitedStore<>(capacity);
    }

    @Override
    public boolean canProvide() {
        return store.countItems() > 0;
    }

    @Override
    public boolean canConsume() {
        return store.countFreeCells() > 0;
    }

    @Override
    public void putResource(Resource resource) {
        store.add(resource);
    }

    @Override
    public Resource takeResource() throws StorageIsEmptyException {
        Resource resource = store.getFirst();
        if (resource == null)
            throw new StorageIsEmptyException();
        store.remove(resource);
        return resource;
    }

    @Override
    public String toString() {
        return "ResourceStorage{" +
                "capacity=" + store.getCapacity() +
                ", freePlace=" + store.countFreeCells() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceStorage that = (ResourceStorage) o;
        return Objects.equals(store, that.store);
    }

    @Override
    public int hashCode() {
        return Objects.hash(store);
    }
}
