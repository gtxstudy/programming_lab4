package com.company.resources;

public class Log extends Resource{

    public Log() {
        super(7, 3, 3);
    }

    @Override
    public String describe() {
        return "Бревно";
    }
}
