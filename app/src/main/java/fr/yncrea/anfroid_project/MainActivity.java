package fr.yncrea.anfroid_project;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import fr.yncrea.anfroid_project.api.GetJson;
import fr.yncrea.anfroid_project.model.EventsList;
import fr.yncrea.anfroid_project.model.ActionsList;

public class MainActivity extends AppCompatActivity {

    private GetJson eventsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://github.com/DasNesel/AndroidStorie/blob/main/story.json")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        eventsList = retrofit.create(GetJson.class);
    }


}