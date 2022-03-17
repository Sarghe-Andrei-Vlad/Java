package com.company;

public class Router extends Node implements Identifiable {

    private String address;

    Router(String name, String address) {
        super(name);
        this.address = address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String printType() { return "Router" + this.getName(); }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Router{" +
                super.toString() +
                "address='" + address +
                '}' + '\n';
    }
}