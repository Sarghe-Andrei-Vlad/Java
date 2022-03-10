package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem {

    private ArrayList<Event> events;
    private ArrayList<Room> rooms;

    public Problem() {
        events = new ArrayList<Event>();
        rooms = new ArrayList<Room>();
    }

    public ArrayList<Event> getEvents() {
        return this.events;
    }

    public ArrayList<Room> getRooms() {
        return this.rooms;
    }

    public void addEvent(Event event){
        if(!this.events.contains(event)){
            this.events.add(event);
        }
    }

    public void addRoom(Room room){
        if(!this.rooms.contains(room)){
            this.rooms.add(room);
        }
    }

}
