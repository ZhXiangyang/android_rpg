package fr.yncrea.Adventure101;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.yncrea.Adventure101.model.ChoicesList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private final ChoicesList mChoicesList;
    private final Context mContext;
    private final int index;

    private static final String TAG = "RecyclerViewAdapter";


    public class ViewHolder extends RecyclerView.ViewHolder {

        Button choice1;
        Button choice2;
        ConstraintLayout parentlayout;
        TextView description;
        TextView observer;

        // Récupération des éléments des layouts à ajouter et modifier dans le RecyclerView
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.description);
            observer = itemView.findViewById(R.id.observer);
            choice1 = itemView.findViewById(R.id.choix1);
            choice2 = itemView.findViewById(R.id.choix2);
            parentlayout = itemView.findViewById(R.id.rv_main);
        }

    }

    // Constructeur du RecyclerView prenant en paramètre la liste des choix et l'index du choix présent
    public RecyclerViewAdapter(ChoicesList mChoicesList, Context mContext, int index) {
        this.mChoicesList = mChoicesList;
        this.mContext = mContext;
        this.index = index;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("onCreateViewHolder", "inflate");

        // Préparation à l'afficheage des nouveaux éléments dans le RecyclerView
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_textviews, parent, false);
        RecyclerView.ViewHolder holder = new ViewHolder(view);
        return (ViewHolder) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder called");

        // Mis à jour des éléments du layout
        holder.description.setText(mChoicesList.choices.get(position).description);
        holder.observer.setText(mChoicesList.choices.get(position).observer);
        holder.choice1.setText(mChoicesList.choices.get(position).possibleActions.get(0).name);
        holder.choice2.setText(mChoicesList.choices.get(position).possibleActions.get(1).name);

        // Listener sur les boutons choix qui mettront à jour le RecyclerView avec le choix fait
        holder.choice1.setOnClickListener(v -> {
            int target = mChoicesList.choices.get(position).possibleActions.get(0).targetEvent;
            Log.d(TAG, "onClick: clicked on: " + target);

            onBindViewHolder(holder, target);
        });
        holder.choice2.setOnClickListener(v -> {
            int target = mChoicesList.choices.get(position).possibleActions.get(1).targetEvent;
            Log.d(TAG, "onClick: clicked on: " + target);

            onBindViewHolder(holder, target);
        });


    }

    @Override
    public int getItemCount() {
        return 1;
        //return mChoicesList.getChoices().get(0).getPossibleActions().size();
    }




}