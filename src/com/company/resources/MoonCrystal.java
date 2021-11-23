package com.company.resources;

public class MoonCrystal extends Resource {
    public MoonCrystal(float durability, float beauty, float rarity) {
        super(5, 8, 10);
    }

    @Override
    public String describe() {
        return "Лунит";
    }
}
