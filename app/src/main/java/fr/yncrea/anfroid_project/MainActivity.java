/**
 *      Android Project
 *      BASSEZ Martin, BRUGE Fabien, LICETTE Matthieu, TE Nicolas
 */
package fr.yncrea.anfroid_project;

import androidx.annotation.XmlRes;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }
}