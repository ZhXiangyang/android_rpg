/**
 *      Android Project
 *      BASSEZ Martin, BRUGE Fabien, LICETTE Matthieu, TE Nicolas
 */
package fr.yncrea.android_rpg;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.yncrea.android_rpg.api.GetEvents;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "fr.yncrea.android_rpg.MESSAGE";

    private GetEvents choicesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*GetEvents events = getJson.getInstance().create(GetEvents.class);
        Call<ChoicesList> call = events.getChoicesList();
        call.enqueue(new Callback<ChoicesList>() {
            @Override
            public void onResponse(Call<ChoicesList> call, Response<ChoicesList> response) {

                //initRecyclerView(response.body());
                //Log.d(TAG, "onResponse: " + response.body());
                Log.d("getEvents", "*********************************** success " + response.body());
                List<Choice> choices = response.body().getChoices();
                Log.d("getSize", "*********************************** choices " + choices.size());
                List<PossibleAction> possibilities = choices.get(0).getPossibleActions();
                Log.d("getName0", "*********************************** choices " + possibilities.get(0).getName());
                //possibilities.get(0);


            }

            @Override
            public void onFailure(Call<ChoicesList> call, Throwable t) {
                Log.w("getEvents", "*********************************** failure");
                //Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });*/
        // RecyclerView recyclerView = (RecyclerView) findViewById(R.id.buttonSuite);
    }

    public void suiteFunction(View view) {
        TextView message = findViewById(R.id.presentation);
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
        else if(message.getText().toString().contains("grossiers")){
            Intent intent = new Intent(this, GameController.class);
            TextView editText = (TextView) findViewById(R.id.presentation);
            String msg = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, msg);
            startActivity(intent);
        }
        Log.d("myTAG", "suiteFunction: "+message.getText());

    }
}