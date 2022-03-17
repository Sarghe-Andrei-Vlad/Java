package com.company;

public class Computer extends Node implements Identifiable, Storage {

    private String address;
    private int storageCapacity;

    public Computer(String name, String address, int storageCapacity) {
        super(name);
        this.address = address;
        this.storageCapacity = storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String printType() { return "Computer" + this.getName(); }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public int getStorageCapacity() {
        return storageCapacity;
    }

    @Override
    public String toString() {
        return "Computer{" +
                super.toString() +
                "address='" + address +
                ", storageCapacity=" + getStorageCapacity() + getStorageUnit() +
                '}' + '\n';
    }
}
