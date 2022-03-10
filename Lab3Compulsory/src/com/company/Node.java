package com.company;

import java.util.HashMap;
import java.util.Map;

public abstract class Node{
    private String name;
    private Map<Node, Integer> cost = new HashMap<>();

    Node(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Node, Integer> getCost() {
        return cost;
    }

    public void setCost(Node node, int value) {
        cost.put(node, value);
    }

    public void show(){
        System.out.println(this.getName());
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }

    /*@Override
    public int compareTo(Node other) {
        return this.name.compareTo(other.name);
    }*/

}