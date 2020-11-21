/**
 *      Android Project
 *      BASSEZ Martin, BRUGE Fabien, LICETTE Matthieu, TE Nicolas
 */
package fr.yncrea.android_rpg;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import fr.yncrea.android_rpg.model.ActionsList;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import fr.yncrea.android_rpg.model.ActionsList;
import fr.yncrea.android_rpg.model.EventsList;
import fr.yncrea.android_rpg.api.GetEvents;

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

        //getJson();
        // RecyclerView recyclerView = (RecyclerView) findViewById(R.id.buttonSuite);
    }

    public void suiteFunction(View view) {
        TextView message = findViewById(R.id.prez);
        Button suiteBtn = findViewById(R.id.buttonSuite);
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

    }

    private void getJson() {
        try {
            Response<EventsList> response = eventsList.getEvents().execute();
            if (response.isSuccessful()) {
                List<ActionsList> actionsList = response.body().possibleActions;
                Log.d("getJson", "success");
            } else {
                Log.w("getJson", "fail");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}