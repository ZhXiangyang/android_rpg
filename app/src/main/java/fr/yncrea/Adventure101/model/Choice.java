package fr.yncrea.Adventure101.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Choice {

    @SerializedName("id")
    public Integer id_choice;

    public String description;
    public String observer;
    public List<PossibleAction> possibleActions;

}