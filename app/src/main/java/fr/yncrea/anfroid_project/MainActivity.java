package fr.yncrea.anfroid_project;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import android.util.Log;


import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import fr.yncrea.anfroid_project.model.EventsList;
import fr.yncrea.anfroid_project.api.GetEvents;

public class MainActivity extends AppCompatActivity {

    private GetEvents eventsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dasnesel.github.io/AndroidStory/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        eventsList = retrofit.create(GetEvents.class);
    }

    private void getJson() {
        GetEvents response = eventsList;
        if (response != null) {
            Log.d("test", "success");
        }
    }
}