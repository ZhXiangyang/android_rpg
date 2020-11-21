package fr.yncrea.anfroid_project.model;

import java.util.List;

// structure of events from json
public class EventsList {
    public int id;
    public String description;
    public String observer;
    public List<ActionsList> possibleActions;
}
