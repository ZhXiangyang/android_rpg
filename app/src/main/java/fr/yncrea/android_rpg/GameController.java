package fr.yncrea.android_rpg;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.yncrea.android_rpg.api.GetEvents;
import fr.yncrea.android_rpg.api.getJson;
import fr.yncrea.android_rpg.model.Choice;
import fr.yncrea.android_rpg.model.ChoicesList;
import fr.yncrea.android_rpg.model.PossibleAction;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameController extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_controller);

        GetEvents events = getJson.getInstance().create(GetEvents.class);
        Call<ChoicesList> call = events.getChoicesList();
        call.enqueue(new Callback<ChoicesList>() {
            @Override
            public void onResponse(Call<ChoicesList> call, Response<ChoicesList> response) {
                //Log.d(TAG, "onResponse: " + response.body());
                Log.d("getEvents", "*********************************** success " + response.body());
                List<Choice> choices = response.body().getChoices();
                Log.d("getSize", "*********************************** choices " + choices.size());
                List<PossibleAction> possibilities = choices.get(0).getPossibleActions();
                Log.d("getName0", "*********************************** choices " + possibilities.get(0).getName());
                //possibilities.get(0);


                /*TextView dynamicTextView = new TextView(this);
                dynamicTextView.setLayoutParams(new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT));
                dynamicTextView.setText(" Hello World ");
                dynamicTextView.setTextColor(Color.WHITE);
                (View)findViewById(R.id.rv).addView(dynamicTextView);*/

                initRecyclerView(response.body(), 0);
                /*RecyclerView rv = (RecyclerView)findViewById(R.id.rv);
                TextView description = (TextView)findViewById(R.id.textView);
                description.setText(choices.get(0).getDescription());
                TextView observer = (TextView) findViewById(R.id.observer);
                observer.setText(choices.get(0).getObserver());
                for(int i = 0; i < possibilities.size(); i++){

                }*/

            }

            @Override
            public void onFailure(Call<ChoicesList> call, Throwable t) {
                Log.w("getEvents", "*********************************** failure");
                //Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        /*
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);*/

    }

    private void initRecyclerView(ChoicesList mChoices, int pos){
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv_main);

        Log.d("initRecyclerView", "execution");

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mChoices, this, pos);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

    }
}
