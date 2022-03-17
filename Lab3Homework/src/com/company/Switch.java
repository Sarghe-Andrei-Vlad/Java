package com.company;

public class Switch extends Node implements Identifiable {

    private String address;

    Switch(String name, String address) {
        super(name);
        this.address = address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String printType() { return "Switch" + this.getName(); }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Switch{" +
                super.toString() +
                "address='" + address +
                '}' + '\n';
    }
}