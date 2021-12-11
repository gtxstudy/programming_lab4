package com.company.exceptions;

public class StorageIsEmptyException extends RuntimeException{
    public StorageIsEmptyException(){
        super("В хранилище ничего не осталось");
    }
}
