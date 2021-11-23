package com.company.resources.interactors;

import com.company.resources.Resource;

public interface IResourceProvider {
    Resource takeResource();
    boolean canProvide();
}
