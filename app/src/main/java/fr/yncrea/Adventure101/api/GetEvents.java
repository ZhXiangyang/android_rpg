package fr.yncrea.Adventure101.api;

import fr.yncrea.Adventure101.model.ChoicesList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetEvents {
    @GET("actions.json")
    Call<ChoicesList> getChoicesList();
}
