package com.company.resources;

import java.util.Objects;

public abstract class Resource {

    private final float durability, beauty, rarity;

    public Resource(float durability, float beauty, float rarity) {
        this.beauty = beauty;
        this.durability = durability;
        this.rarity = rarity;
    }

    public abstract String describe();

    public float getDurability() {
        return durability;
    }

    public float getBeauty() {
        return beauty;
    }

    public float getRarity() {
        return rarity;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "durability=" + durability +
                ", beauty=" + beauty +
                ", rarity=" + rarity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resource resource = (Resource) o;
        return Float.compare(resource.durability, durability) == 0 && Float.compare(resource.beauty, beauty) == 0
                && Float.compare(resource.rarity, rarity) == 0 && describe().equals(resource.describe());
    }

    @Override
    public int hashCode() {
        return Objects.hash(durability, beauty, rarity, describe());
    }
}
