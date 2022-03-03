package com.company;

public class Main {

    public static void main(String[] args) {

	    Event C1 = new Event("C1",100,8,10);
        Event C2 = new Event("C2",100,10,12);
        Event L1 = new Event("L1",30,8,10);
        Event L2 = new Event("L2",30,10,12);
        Event L3 = new Event("L3",30,10,12);

        Room R1 = new Room("401", 30, RoomType.LAB);
        Room R2 = new Room("403", 30, RoomType.LAB);
        Room R3 = new Room("405", 30, RoomType.LAB);
        Room R4 = new Room("309", 100, RoomType.LECTURE_HALLl);

        System.out.println(C1);
        System.out.println(C2);
        System.out.println(L1);
        System.out.println(L2);
        System.out.println(L3);

        System.out.println(R1);
        System.out.println(R2);
        System.out.println(R3);
        System.out.println(R4);
    }
}
