package com.company.buildings;

import com.company.IPositioned;
import com.company.Position;
import com.company.exceptions.NotEnoughResourcesException;
import com.company.resources.interactors.IResourceConsumer;
import com.company.resources.interactors.ResourceStorage;
import com.company.resources.Resource;

import java.util.Objects;

public class ConstructionSite implements IResourceConsumer, IPositioned {

    private final Warehouse warehouse;
    private final Position position;
    private int resourceCount;

    public ConstructionSite(Position position){
        this.position = position;
        resourceCount = 0;
        warehouse = new Warehouse();
    }

    public IBuilding buildHouse(String buildingName) {
        if (resourceCount < BuildingType.HOUSE.neededResource)
            throw new NotEnoughResourcesException(BuildingType.HOUSE.neededResource, resourceCount);
        int tookResources = 0;
        while (warehouse.canProvide() && tookResources < BuildingType.HOUSE.neededResource) {
            Resource resource = warehouse.takeResource();
            System.out.printf("Достан %s и израсходовал в процессе стройки\n", resource.describe());
            tookResources += 1;
        }
        resourceCount -= BuildingType.HOUSE.neededResource;

        return new IBuilding() {
            @Override
            public String getName() {
                return buildingName;
            }

            @Override
            public BuildingType getType() {
                return BuildingType.HOUSE;
            }

            @Override
            public Position getCoordinates() {
                return ConstructionSite.this.getCoordinates();
            }
        };
    }

    public int getResourceCount() {
        return resourceCount;
    }

    @Override
    public void putResource(Resource resource) {
        warehouse.putResource(resource);
        resourceCount -= 1;
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
                ", resourceCount=" + resourceCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConstructionSite that = (ConstructionSite) o;
        return resourceCount == that.resourceCount && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, resourceCount);
    }

    public static class Warehouse extends ResourceStorage {
        public Warehouse() {
            super(100);
        }
    }

    interface IBuilding extends IPositioned{
        String getName();
        BuildingType getType();
    }

    enum BuildingType {
        HOUSE(140);

        final int neededResource;

        BuildingType(int neededResourceCount) {
            this.neededResource = neededResourceCount;
        }

    }

}
