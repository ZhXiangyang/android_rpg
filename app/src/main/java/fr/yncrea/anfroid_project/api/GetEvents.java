package fr.yncrea.anfroid_project.api;

import fr.yncrea.anfroid_project.model.EventsList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetEvents {
    @GET("story.json")
    Call<EventsList> getEvents(); // à checker
}
