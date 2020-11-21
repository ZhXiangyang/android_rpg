package fr.yncrea.android_rpg.model;

import java.util.List;

// structure of events from json
public class EventsList {
    public int id;
    public String description;
    public String observer;
    public List<ActionsList> possibleActions;
}
