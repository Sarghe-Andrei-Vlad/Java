package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ArrayList<Event> Events = new ArrayList<Event>();
        ArrayList<Room> Rooms = new ArrayList<Room>();

        Events.add(new Event("C1",100,8,10));
        Events.add(new Event("C2",100,10,12));
        Events.add(new Event("L1",30,8,10));
        Events.add(new Event("L2",30,10,12));
        Events.add(new Event("L3",30,10,12));

        Rooms.add(new Hall("309", 100, true));
        Rooms.add(new Lab("401", 30, "Windows"));
        Rooms.add(new Lab("403", 30, "MacOS"));
        Rooms.add(new Lab("405", 30, "Linux"));

        Problem P = new Problem();

        for (Event x : Events
             ) {
            P.addEvent(x);
        }

        for (Room x : Rooms
             ) {
            P.addRoom(x);
        }

        solution S = new solution(P);
        S.getSolution();

    }
}
