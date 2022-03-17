package com.company;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Network {
    private List<Node> nodes = new ArrayList<>();

    public Network(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public List<Node> getNodes() {
        return nodes;
    }

    @Override
    public String toString() {
        Collections.sort(nodes);
        return "Network{" +
                "nodes=" + '\n' + nodes +
                '}';
    }

    public void orderAdress() {
        //this.name.compareTo(other.name);
        List<Node> identifiable = new ArrayList<>();
        for(Node x : this.nodes){
            if(x instanceof Identifiable){
                identifiable.add(x);
            }
        }
        identifiable.sort(Comparator.comparing(Node::getAddress));
        System.out.println("\n" + identifiable);
    }

}
