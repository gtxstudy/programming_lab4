package com.company.exceptions;

public class StoreOverflowedException extends RuntimeException{

    public StoreOverflowedException() {
        super("LimitedStore was overflowed");
    }

}
