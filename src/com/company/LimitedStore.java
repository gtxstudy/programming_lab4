package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LimitedStore<T> {
    private final Object[] items;

    public LimitedStore(int itemsLimit){
        items = new Object[itemsLimit];
    }

    public void add(T item){
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                return;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public void remove(T item){
        for (int i = 0; i < items.length; i++) {
            if (items[i] == item) {
                items[i] = null;
                return;
            }
        }
    }

    public T getFirst(){
        for (Object item : items) {
            if (item != null)
                return (T)item;
        }
        return null;
    }


    public List<T> getAll(){
        ArrayList<T> itemsToReturn = new ArrayList<>();
        for (Object item : items) {
            if (item != null)
                itemsToReturn.add((T)item);
        }
        return itemsToReturn;
    }


    public int countFreeCells(){
        int counter = 0;
        for (Object item : items) {
            if (item == null)
                counter++;
        }
        return counter;
    }

    public int countItems(){
        int counter = 0;
        for (Object item : items) {
            if (item != null)
                counter++;
        }
        return counter;
    }

    public int getCapacity(){ return items.length;}

    @Override
    public String toString() {
        return "LimitedStore{" +
                "items=" + Arrays.toString(items) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LimitedStore<?> that = (LimitedStore<?>) o;
        return Arrays.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(items);
    }
}
