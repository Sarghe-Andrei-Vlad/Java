package com.company;

import java.util.ArrayList;

public class solution {

    Problem pb;

    private ArrayList<Event> toSchedule;
    private ArrayList<Room> availableRooms;

    public solution(Problem pb) {
        this.toSchedule = pb.getEvents();
        this.availableRooms = pb.getRooms();;
    }

    public ArrayList<Event> getToSchedule() {
        return toSchedule;
    }

    public void setToSchedule(ArrayList<Event> toSchedule) {
        this.toSchedule = toSchedule;
    }

    public ArrayList<Room> getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(ArrayList<Room> availableRooms) {
        this.availableRooms = availableRooms;
    }

    public void getSolution(){
        ArrayList<String> Schedule = new ArrayList<String>();
        for ( Event x : toSchedule
             ) {
            for ( Room y : availableRooms
                 ) {
                if( x.getParticipantNr() <= y.getCapacity() ){
                    System.out.println(x.getName() + " -> " + y.getName());
                }
                //toSchedule.
                //availableRooms.remove(y);
                //break;
            }
            //toSchedule.add(x);
        }
        System.out.println("Hello world");
    }

}