package com.company.exceptions;

public class TrunkNotOpenedException extends Exception{

    public TrunkNotOpenedException() {
        super("Вы не можете получить доступ к содержимому багажника, т.к. он не открыт");
    }

}
