package fr.yncrea.anfroid_project;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import retrofit2.Retrofit;
import fr.yncrea.anfroid_project.GetJsonApi;

public class MainActivity extends AppCompatActivity {

    private GetJsonApi eventsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .build();

    eventsList = retrofit.create(getJsonApi.class);
}