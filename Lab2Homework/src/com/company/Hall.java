package com.company;

public class Hall extends Room{

    private boolean hasProjector;

    public Hall(String name, int capacity, boolean hasProjector) {
        setName(name);
        setCapacity(capacity);
        setType("Hall");
        this.hasProjector= hasProjector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isHasProjector() {
        return hasProjector;
    }

    public void setHasProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
    }

    @Override
    public String toString() {
        return "Hall{" +
                "name='" + getName() + '\'' +
                ", capacity=" + getCapacity() +
                ", type='" + getType() + '\'' +
                ", hasProjector=" + hasProjector +
                '}';
    }

}
