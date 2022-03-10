package com.company;

public class Router extends Node implements Identifiable {

    private String address;

    Router(String name, String address) {
        super(name);
        this.address = address;
    }

    Router(String name) {
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