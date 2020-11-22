package fr.yncrea.android_rpg;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.yncrea.android_rpg.model.ChoicesList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private ChoicesList mChoicesList;
    private Context mContext;
    private int index;

    private static final int FIRST_LIST_ITEM_VIEW = 1;
    private static final int SECOND_LIST_ITEM_VIEW = 2;

    private static final String TAG = "RecyclerViewAdapter";

    private List<String> firstList = null;
    private List<String> secondList = null;

    public void setFirstList(List<String> firstList) { this.firstList = firstList; }
    public void setSecondList(List<String> secondList) { this.secondList = secondList; }


    public class ViewHolder extends RecyclerView.ViewHolder {

        Button choice1;
        Button choice2;
        ConstraintLayout parentlayout;
        TextView description;
        TextView observer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.description);
            observer = itemView.findViewById(R.id.observer);
            choice1 = itemView.findViewById(R.id.choix1);
            choice2 = itemView.findViewById(R.id.choix2);
            parentlayout = itemView.findViewById(R.id.cl);
        }

    }

    private class FirstListItemViewHolder extends ViewHolder{
        public FirstListItemViewHolder(View itemView) { super(itemView); }
    }
    private class SecondListItemViewHolder extends ViewHolder{
        public SecondListItemViewHolder(View itemView) { super(itemView); }
    }


    public RecyclerViewAdapter(ChoicesList mChoicesList, Context mContext, int index) {
        this.mChoicesList = mChoicesList;
        this.mContext = mContext;
        this.index = index;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("onCreateViewHolder", "inflate");

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_textviews, parent, false);
        RecyclerView.ViewHolder holder = new ViewHolder(view);
        return (ViewHolder) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder called");


        holder.description.setText(mChoicesList.getChoices().get(index).getDescription());
        holder.observer.setText(mChoicesList.getChoices().get(index).getObserver());
        holder.choice1.setText(mChoicesList.getChoices().get(index).getPossibleActions().get(0).getName());
        holder.choice2.setText(mChoicesList.getChoices().get(index).getPossibleActions().get(1).getName());

        /*holder.choice.setText(mChoicesList.getChoices().get(0).getPossibleActions().get(2).getName());

        holder.parentlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + mChoicesList.getChoices().get(position));

            }
        });*/


    }

    @Override
    public int getItemCount() {
        return 1;
        //return mChoicesList.getChoices().get(0).getPossibleActions().size();
    }




}