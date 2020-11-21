package fr.yncrea.android_rpg.api;

import fr.yncrea.android_rpg.model.EventsList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetEvents {
    @GET("story.json")
    Call<EventsList> getEvents(); // à checker
}
