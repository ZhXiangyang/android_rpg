package fr.yncrea.android_rpg.api;

import fr.yncrea.android_rpg.model.Choice;
import fr.yncrea.android_rpg.model.ChoicesList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetEvents {
    @GET("actions.json")
    Call<ChoicesList> getChoicesList(); // à checker
}
