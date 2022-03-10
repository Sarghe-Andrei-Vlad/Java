package com.company;

import java.util.Objects;

public abstract class Room {

    protected String name;
    protected int capacity;
    protected String type;

    abstract String getName();

    abstract void setName(String name);

    abstract int getCapacity();

    abstract void setCapacity(int capacity);

    abstract String getType();

    abstract void setType(String type);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return capacity == room.capacity && Objects.equals(name, room.name) && type == room.type;
    }

}
