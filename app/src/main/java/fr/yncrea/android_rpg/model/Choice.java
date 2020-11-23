package fr.yncrea.android_rpg.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Choice {

    @SerializedName("id")
    public Integer id_choice;

    public String description;
    public String observer;
    public List<PossibleAction> possibleActions;

}