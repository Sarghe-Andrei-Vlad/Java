package com.company;

import java.util.Objects;

public class Event {

    private String name;
    private int participantNr;
    private int startTime;
    private int endTime;

    public Event(String name, int participantNr, int startTime, int endTime) {
        this.name = name;
        this.participantNr = participantNr;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParticipantNr() {
        return participantNr;
    }

    public void setParticipantNr(int participantNr) {
        this.participantNr = participantNr;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", participantNr=" + participantNr +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return participantNr == event.participantNr && startTime == event.startTime && endTime == event.endTime && Objects.equals(name, event.name);
    }

}
