package com.company.resources.interactors;

import com.company.exceptions.StorageIsEmptyException;
import com.company.resources.Resource;

public class ResourceCourier {
    public static void deliver(IResourceConsumer consumer, IResourceProvider provider) throws StorageIsEmptyException {
        System.out.println("Доставка начата");
        while (consumer.canConsume() && provider.canProvide()){
            Resource resource = provider.takeResource();
            System.out.printf("Ресурс %s доставлен\n", resource.describe());
            consumer.putResource(resource);
        }
        System.out.println("Доставка закончена");
    }
}
