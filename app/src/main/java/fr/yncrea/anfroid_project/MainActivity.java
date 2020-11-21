/**
 *      Android Project
 *      BASSEZ Martin, BRUGE Fabien, LICETTE Matthieu, TE Nicolas
 */
package fr.yncrea.anfroid_project;

import androidx.annotation.XmlRes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import fr.yncrea.anfroid_project.model.EventsList;
import fr.yncrea.anfroid_project.api.GetEvents;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout layout = null;
    TextView text = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layout = (ConstraintLayout) ConstraintLayout.inflate(this, R.layout.activity_main, null);


        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dasnesel.github.io/AndroidStory/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GetEvents eventsList = retrofit.create(GetEvents.class);
        //RecyclerView recyclerView = (RecyclerView) findViewById(R.id.buttonSuite);
    }


}