package com.company.buildings;

import com.company.IPositioned;
import com.company.Position;
import com.company.resources.interactors.IResourceConsumer;
import com.company.resources.interactors.Warehouse;
import com.company.resources.Resource;

import java.util.Objects;

public class ConstructionSite implements IResourceConsumer, IPositioned {

    private Warehouse warehouse;
    private final Position position;
    private int neededResources;

    public ConstructionSite(Position position, int neededResources) throws Exception {
        this.position = position;
        if (neededResources < 1)
            throw new Exception("Incorrect needed resources value");
        this.neededResources = neededResources;
    }

    public void build() {
        while (warehouse.canProvide() && neededResources > 0) {
            Resource resource = warehouse.takeResource();
            System.out.printf("Достан %s и израсходовал в процессе стройки\n", resource.describe());
            neededResources -= 1;
        }
        if (neededResources < 1)
            System.out.println("Стройка закончена!");
    }

    @Override
    public void putResource(Resource resource) {
        warehouse.putResource(resource);
    }

    @Override
    public boolean canConsume() {
        return warehouse.canConsume();
    }

    @Override
    public Position getCoordinates() {
        return position;
    }

    @Override
    public String toString() {
        return "ConstructionSite{" +
                "position=" + position +
                ", neededResources=" + neededResources +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConstructionSite that = (ConstructionSite) o;
        return neededResources == that.neededResources && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, neededResources);
    }
}
