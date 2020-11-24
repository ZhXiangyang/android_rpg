package fr.yncrea.Adventure101;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import fr.yncrea.Adventure101.api.GetEvents;
import fr.yncrea.Adventure101.api.getJson;
import fr.yncrea.Adventure101.database.StoryEntity;
import fr.yncrea.Adventure101.model.Choice;
import fr.yncrea.Adventure101.model.ChoicesList;
import fr.yncrea.Adventure101.model.PossibleAction;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameController extends AppCompatActivity {

    private final Executor backgroundExecutor = Executors.newSingleThreadExecutor();
    private StoryEntity db;
    public int id_db;
    public String name_db;
    public int target_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_controller);

        // Appel de l'API et création de la BDD
        StoryEntity appDb = StoryEntity.getInstance(this);
        GetEvents events = getJson.getInstance().create(GetEvents.class);
        Call<ChoicesList> call = events.getChoicesList();

        // récupération des données JSON de l'API
        call.enqueue(new Callback<ChoicesList>() {
            @Override
            public void onResponse(Call<ChoicesList> call, Response<ChoicesList> response) {
                //Log.d(TAG, "onResponse: " + response.body());
                Log.d("getEvents", "*********************************** success " + response.body());
                List<Choice> choices = response.body().choices;
                Log.d("getSize", "*********************************** " + choices.size() + " choices");
                List<PossibleAction> possibilities = choices.get(0).possibleActions;
                Log.d("getName0", "*********************************** choice 0 : " + possibilities.get(0).name);

                // Stockage des boutons de choix dans la BDD
                backgroundExecutor.execute(() -> {
                    for(int i = 0; i < choices.size(); i++){
                        appDb.storyDao().insert(choices.get(i).possibleActions.get(0));
                        appDb.storyDao().insert(choices.get(i).possibleActions.get(1));
                    }
                    Log.d("db_test", "succes db insert");
                });

                /*backgroundExecutor.execute(() -> {
                    PossibleAction getFromDb = appDb.storyDao().getAll().get(7);
                    Log.d("affich_db", "uid : " + getFromDb.uid + ", name : " + getFromDb.name + ", target : " + getFromDb.targetEvent);
                });*/

                //Appel du ReyclerView
                initRecyclerViews(response.body(), 0);

            }

            @Override
            public void onFailure(Call<ChoicesList> call, Throwable t) {
                Log.w("getEvents", "*********************************** failure");
            }
        });

    }

    // Initialisation et execution du RecyclerView
    private void initRecyclerViews(ChoicesList mChoices, int pos){
        Log.d("initRecyclerView", "execution");
        RecyclerView rv = findViewById(R.id.rv_main);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mChoices, this, pos);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

    }
}
