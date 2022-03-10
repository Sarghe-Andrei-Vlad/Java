package com.company;

import java.util.ArrayList;
import java.util.List;

public class Network {

    private List<Node> nodes = new ArrayList<>();

    public Network(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void sortNodes(){

    }

    @Override
    public String toString() {
        return "Network{" +
                "nodes=" + nodes +
                '}';
    }


}