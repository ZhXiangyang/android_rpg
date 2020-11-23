package fr.yncrea.android_rpg;

import android.content.Context;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import fr.yncrea.android_rpg.model.ChoicesList;

public class initRecyclerView extends AppCompatActivity {
    public static void initRecyclerViewer(RecyclerView recycler, Context mContext,ChoicesList mChoices, int pos){
        RecyclerView rv = recycler;
        //ConstraintLayout rv_main = (ConstraintLayout) findViewById(R.id.textviews);
        Log.d("initRecyclerView", "execution");

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mChoices, mContext, pos);
        rv.setLayoutManager(new LinearLayoutManager(mContext));
        rv.setAdapter(adapter);
        /*Button clickChoix1 = (Button)rv_main.findViewById(R.id.choix1);
        int choix1Fait = mChoices.getChoices().get(pos).getPossibleActions().get(0).getTargetEvent();
        clickChoix1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("click in game controller", "onClick: clicked on: " + mChoices.getChoices().get(pos).getPossibleActions().get(0).getTargetEvent());
                initRecyclerView(mChoices, choix1Fait);
            }
        });*/

    }

}
