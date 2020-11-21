/**
 *      Android Project
 *      BASSEZ Martin, BRUGE Fabien, LICETTE Matthieu, TE Nicolas
 */
package fr.yncrea.anfroid_project;

import androidx.annotation.XmlRes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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

    private GetEvents eventsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.buttonSuite);
    }

    public void suiteFunction(View view) {
        TextView message = (TextView)findViewById(R.id.prez);
        Button suiteBtn = (Button)findViewById(R.id.buttonSuite);
        if(message.getText().toString().contains("Salut")){
            message.setText(R.string.prez2);
        }
        else if(message.getText().toString().contains("moyen")){
            message.setText(R.string.prez3);
        }
        else if(message.getText().toString().contains("Guffin")){
            message.setText(R.string.prez4);
        }
        else if(message.getText().toString().contains("souhaitant")){
            message.setText(R.string.prez5);
        }
        else if(message.getText().toString().contains("Malheureusement")){
            message.setText(R.string.prez6);
            suiteBtn.setText(R.string.go);
        }
        Log.d("myTAG", "suiteFunction: "+message.getText());
      
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dasnesel.github.io/AndroidStory/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        eventsList = retrofit.create(GetEvents.class);
    }

    private void getJson() {
        Response<GetEvents> response = eventsList;
        if (response != null) {
            Log.d("test", "success");
        }
    }
}