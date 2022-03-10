package com.company;

public class Switch extends Node implements Identifiable {

    private String address;

    Switch(String name, String address) {
        super(name);
        this.address = address;
    }

    Switch(String name) {
        super(name);
    }

    @Override
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}