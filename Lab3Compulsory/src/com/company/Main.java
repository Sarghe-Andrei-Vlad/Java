package com.company;

public class Main {

    public static void main(String[] args) {
        //v1 (Computer A) v2 (Router A) v3 (Switch A) v4 (Switch B) v5 (Router B) v6 (Computer B).
        Computer v1 = new Computer("A", "1", 100);
        Router v2 = new Router("A", "2");
        Switch v3 = new Switch("A","3");

        v1.show();
        v2.show();
        v3.show();

    }
}
