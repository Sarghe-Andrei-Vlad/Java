package com.company;

import java.util.HashMap;
import java.util.Map;

public abstract class Node implements Comparable<Node> {
    private String name;
    private Map<Node, Integer> cost = new HashMap<>();

    public Node(String name) {
        this.name = name;
    }

    public Map<Node, Integer> getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(Node node, int value) {
        cost.put(node, value);
    }

    abstract String printType();

    abstract String getAddress();

    public String printCost(Map<Node, Integer> cost){
        String rez = new String();
        for( Map.Entry<Node,Integer> entry : cost.entrySet() ){
            Node node = entry.getKey();
            Integer price = entry.getValue();
            rez += "to " + node.printType() +  " is " + price + ", ";
        }
        return rez;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name +
                ", cost " + printCost(this.cost) +
                '}';
    }

    @Override
    public int compareTo(Node other) {
        return this.name.compareTo(other.name);
    }

}
