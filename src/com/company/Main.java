package com.company;

import com.company.buildings.ConstructionSite;
import com.company.exceptions.StorageIsEmptyException;
import com.company.exceptions.TrunkNotOpenedException;
import com.company.resources.Log;
import com.company.resources.Plank;
import com.company.resources.Resource;
import com.company.resources.interactors.ResourceStorage;
import com.company.transport.Rover;

public class Main {

    public static void main(String[] args) {
        Plank plank = new Plank();
        Log log = new Log();
        Rover rover = new Rover(new Position(0, 0), 2, "вездеход");

        ConstructionSite constructionSite = new ConstructionSite(new Position(10, 5));

        try {
            rover.getTrunk().open();
            rover.getTrunk().getStorage().putResource(plank);
            rover.getTrunk().getStorage().putResource(log);
        } catch (TrunkNotOpenedException e) {
            e.printStackTrace();
        }
        finally {
            rover.getTrunk().close();
        }
        rover.moveTo(constructionSite);

        try {
            rover.getTrunk().open();
            ResourceStorage storage = rover.getTrunk().getStorage();
            while (storage.canProvide() && constructionSite.canConsume()){
                Resource resource = storage.takeResource();
                constructionSite.putResource(resource);
            }
        } catch (TrunkNotOpenedException e) {
            e.printStackTrace();
        } finally {
            rover.getTrunk().close();
        }

        ConstructionSite.IBuilding house = constructionSite.buildHouse("MyHouse");
        System.out.printf("Здание %s типа %s на позиции %s", house.getName(), house.getType(), house.getCoordinates());
    }
}
