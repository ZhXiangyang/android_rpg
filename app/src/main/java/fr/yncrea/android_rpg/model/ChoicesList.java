package fr.yncrea.android_rpg.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChoicesList {

    @SerializedName("choices")
    @Expose
    private List<Choice> choices = null;

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

}