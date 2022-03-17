package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //v1 (Computer A) v2 (Router A) v3 (Switch A) v4 (Switch B) v5 (Router B) v6 (Computer B).
        Node v1 = new Computer("A", "153:132:00:88", 128);
        Node v2 = new Router("A", "138:102:00:23");
        Node v3 = new Switch("A","955:784:00:33");
        Node v4 = new Switch("B","777:777:00:63");
        Node v5 = new Router("B","423:723:00:21");
        Node v6 = new Computer("B","155:44:00:99", 256);

        List<Node> MyNodes = new ArrayList<>();

        v1.setCost(v2,10);
        v1.setCost(v3,50);
        v2.setCost(v1,10);
        v2.setCost(v3,20);
        v2.setCost(v4,20);
        v2.setCost(v5,20);
        v3.setCost(v1,50);
        v3.setCost(v2,20);
        v3.setCost(v4,10);
        v4.setCost(v2,20);
        v4.setCost(v3,10);
        v4.setCost(v5,30);
        v4.setCost(v6,10);
        v5.setCost(v2,20);
        v5.setCost(v4,30);
        v5.setCost(v6,20);
        v6.setCost(v4,10);
        v6.setCost(v5,20);

        MyNodes.add(v1);
        MyNodes.add(v2);
        MyNodes.add(v3);
        MyNodes.add(v4);
        MyNodes.add(v5);
        MyNodes.add(v6);

        Network X = new Network(MyNodes);
        System.out.print(X.toString());
        X.orderAdress();
    }
}
