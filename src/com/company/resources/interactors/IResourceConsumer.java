package com.company.resources.interactors;

import com.company.resources.Resource;

public interface IResourceConsumer {
    void putResource(Resource resource);
    boolean canConsume();
}
