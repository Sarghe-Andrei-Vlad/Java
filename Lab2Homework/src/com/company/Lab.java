package com.company;

public class Lab extends Room{

    private String opSys;

    public Lab(String name, int capacity, String opSys) {
        setName(name);
        setCapacity(capacity);
        setType("Lab");
        this.opSys=opSys;
    }

    public String getName() { return name; }

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

    public String getOpSys() {
        return opSys;
    }

    public void setOpSys(String opSys) {
        this.opSys = opSys;
    }

    @Override
    public String toString() {
        return "Lab{" +
                "name='" + getName() + '\'' +
                ", capacity=" + getCapacity() +
                ", type='" + getType() + '\'' +
                ", opSys='" + opSys + '\'' +
                '}';
    }

}
