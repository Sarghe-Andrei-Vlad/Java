package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public interface Storage {
    int getStorageCapacity();
    default String getStorageUnit() {
        List<String> units = new ArrayList<>();
        units.add("kB");
        units.add("MB");
        units.add("GB");
        Random rand = new Random();
        int i = rand.nextInt(2) + 1;
        return " " + units.get(i);
    }
}
