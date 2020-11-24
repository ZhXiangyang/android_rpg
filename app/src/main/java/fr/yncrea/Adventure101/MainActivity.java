/**
 *      Android Project
 *      BASSEZ Martin, BRUGE Fabien, LICETTE Matthieu, TE Nicolas
 */
package fr.yncrea.Adventure101;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import fr.yncrea.Adventure101.api.getJson;
import fr.yncrea.Adventure101.model.Choice;
import fr.yncrea.Adventure101.model.ChoicesList;
import fr.yncrea.Adventure101.model.PossibleAction;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import fr.yncrea.Adventure101.api.GetEvents;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "fr.yncrea.android_rpg.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            TextView editText = findViewById(R.id.presentation);
            String msg = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, msg);
            startActivity(intent);
        }
        Log.d("myTAG", "suiteFunction: "+message.getText());

    }
}