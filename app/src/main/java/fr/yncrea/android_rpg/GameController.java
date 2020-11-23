package fr.yncrea.android_rpg;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import fr.yncrea.android_rpg.api.GetEvents;
import fr.yncrea.android_rpg.api.getJson;
import fr.yncrea.android_rpg.database.StoryEntity;
import fr.yncrea.android_rpg.model.Choice;
import fr.yncrea.android_rpg.model.ChoicesList;
import fr.yncrea.android_rpg.model.PossibleAction;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameController extends AppCompatActivity {

    private Executor backgroundExecutor = Executors.newSingleThreadExecutor();
    private StoryEntity db;
    public int id_db;
    public String name_db;
    public int target_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_controller);

        StoryEntity appDb = StoryEntity.getInstance(this);

        GetEvents events = getJson.getInstance().create(GetEvents.class);


            Call<ChoicesList> call = events.getChoicesList();
            call.enqueue(new Callback<ChoicesList>() {
                @Override
                public void onResponse(Call<ChoicesList> call, Response<ChoicesList> response) {
                    //Log.d(TAG, "onResponse: " + response.body());
                    Log.d("getEvents", "*********************************** success " + response.body());
                    List<Choice> choices = response.body().choices;
                    Log.d("getSize", "*********************************** choices " + choices.size());
                    List<PossibleAction> possibilities = choices.get(0).possibleActions;
                    Log.d("getName0", "*********************************** choices " + possibilities.get(0).name);


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

                    initRecyclerViews(response.body(), 0);

                }

                @Override
                public void onFailure(Call<ChoicesList> call, Throwable t) {
                    Log.w("getEvents", "*********************************** failure");
                }
            });

    }

    private void initRecyclerViews(ChoicesList mChoices, int pos){
        Log.d("initRecyclerView", "execution");
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv_main);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mChoices, this, pos);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

    }
}
