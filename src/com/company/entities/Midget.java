package com.company.entities;

public class Midget {
    private final String name;
    private final Gender gender;

    public Midget(Gender gender, String name) {
        this.gender = gender;
        this.name = name;
    }

    public void say(String phrase){
        System.out.printf("%s говорит: %s", name, phrase);
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Midget{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

    public enum Gender {
        MALE,
        FEMALE
    }
}
