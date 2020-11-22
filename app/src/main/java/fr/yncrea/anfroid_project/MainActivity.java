/**
 *      Android Project
 *      BASSEZ Martin, BRUGE Fabien, LICETTE Matthieu, TE Nicolas
 */
package fr.yncrea.anfroid_project;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        Cheese[] cheeses = {
                new Cheese("Parmesan", "Hard, granular cheese"),
                new Cheese("Ricotta", "Italian whey cheese"),
                new Cheese("Fontina", "Italian cow's milk cheese"),
                new Cheese("Mozzarella", "Southern Italian buffalo milk cheese"),
                new Cheese("Cheddar", "Firm, cow's milk cheese"),
        };
        ArrayAdapter<Cheese> cheeseAdapter =
                new ArrayAdapter<Cheese>(this, 0, cheeses) {
                    @Override
                    public View getView(int position,
                                        View convertView,
                                        ViewGroup parent) {
                        Cheese currentCheese = cheeses[position];
                        // Inflate only once
                        if(convertView == null) {
                            convertView = getLayoutInflater()
                                    .inflate(R.layout.custom_item, null, false);
                        }
                        ViewHolder viewHolder = new ViewHolder();
                        viewHolder.cheeseName =
                                (TextView)convertView.findViewById(R.id.cheese_name);
                        viewHolder.cheeseDescription =
                                (TextView)convertView.findViewById(R.id.cheese_description);

                        // Store results of findViewById
                        convertView.setTag(viewHolder);
                        TextView cheeseName =
                                ((ViewHolder)convertView.getTag()).cheeseName;
                        TextView cheeseDescription =
                                ((ViewHolder)convertView.getTag()).cheeseDescription;

                        cheeseName.setText(currentCheese.name);
                        cheeseDescription.setText(currentCheese.description);
                        return convertView;
                    }
                };
        ListView cheeseList = new ListView(this);
        setContentView(cheeseList);
        cheeseList.setAdapter(cheeseAdapter);

        /** 5. Creating a Grid */

        GridView cheeseGrid = new GridView(this);
        setContentView(cheeseGrid);
        cheeseGrid.setNumColumns(2);
        cheeseGrid.setColumnWidth(60);
        cheeseGrid.setVerticalSpacing(20);
        cheeseGrid.setHorizontalSpacing(20);
        cheeseGrid.setAdapter(cheeseAdapter);

        /** 6. Adding Event Listeners */
        cheeseGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long rowId) {

                // Generate a message based on the position
                String message = "You clicked on " + cheeses[position].name;

                // Use the message to create a Snackbar
                Snackbar.make(adapterView, message, Snackbar.LENGTH_LONG)
                        .show(); // Show the Snackbar
            }
        });
    }

    static class Cheese {
        String name;
        String description;

        public Cheese(String name, String description) {
            this.name = name;
            this.description = description;
        }
    }

    static class ViewHolder{
        TextView cheeseName;
        TextView cheeseDescription;
    }
}