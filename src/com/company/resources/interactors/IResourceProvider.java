package com.company.resources.interactors;

import com.company.exceptions.StorageIsEmptyException;
import com.company.resources.Resource;

public interface IResourceProvider {
    Resource takeResource() throws StorageIsEmptyException;
    boolean canProvide();
}
