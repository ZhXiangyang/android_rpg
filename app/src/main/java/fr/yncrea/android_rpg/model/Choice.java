package fr.yncrea.android_rpg.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Choice {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("observer")
    @Expose
    private String observer;
    @SerializedName("possibleActions")
    @Expose
    private List<PossibleAction> possibleActions = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObserver() {
        return observer;
    }

    public void setObserver(String observer) {
        this.observer = observer;
    }

    public List<PossibleAction> getPossibleActions() {
        return possibleActions;
    }

    public void setPossibleActions(List<PossibleAction> possibleActions) {
        this.possibleActions = possibleActions;
    }

}