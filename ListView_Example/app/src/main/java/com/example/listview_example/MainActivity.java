package com.example.listview_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFrag.ItemSelected {

    TextView tvDescription;
   /* ArrayList<String> description = new ArrayList<String>();*/
    String[] description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDescription = findViewById(R.id.tvDescription);
        //first example without arrays.xml
        /*description.add("Description for Item 1");
        description.add("Description for Item 2");
        description.add("Description for Item 3");*/

        description = getResources().getStringArray(R.array.descriptions);

        //this is portrait mode
        if(findViewById(R.id.layout_portrait) != null){
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.fragDescription))
                    .show(manager.findFragmentById(R.id.fragList))
                    .commit();
        }
        //this is landscape mode
        if(findViewById(R.id.layout_land) != null){
            tvDescription.setText(description[0]);
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.fragDescription))
                    .show(manager.findFragmentById(R.id.fragList))
                    .commit();

        }
    }

    @Override
    public void onItemSelected(int position) {
        tvDescription.setText(description[position]);
        if(findViewById(R.id.layout_portrait) != null){
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.fragList))
                    .show(manager.findFragmentById(R.id.fragDescription))
                    .addToBackStack(null)
                    .commit();
        }
    }
}