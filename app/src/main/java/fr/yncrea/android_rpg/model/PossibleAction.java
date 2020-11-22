package fr.yncrea.android_rpg.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PossibleAction {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("targetEvent")
    @Expose
    private Integer targetEvent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTargetEvent() {
        return targetEvent;
    }

    public void setTargetEvent(Integer targetEvent) {
        this.targetEvent = targetEvent;
    }

}