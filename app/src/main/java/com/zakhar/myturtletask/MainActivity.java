package com.zakhar.myturtletask;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends ListActivity implements View.OnClickListener {

    private FloatingActionButton fab;
    private List<Animal> animals;
    private AnimalsAdapter animalsAdapter;
    private int turtleImage;
    private int dolphinImage;
    private List<Integer> animalsImages;
    private List<String> animalNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        turtleImage = R.mipmap.ic_turtle;
        dolphinImage = R.mipmap.ic_dolphin;
        animalsImages = Arrays.asList(turtleImage, dolphinImage);

        animalNames = Arrays.asList(getResources().getStringArray(R.array.animalNames));
        animals = new ArrayList<>();

        fill_data();

        animalsAdapter = new AnimalsAdapter(this, animals);
        setListAdapter(animalsAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        animalsAdapter.setSelectedIndex(position);
        animalsAdapter.notifyDataSetChanged();
    }

    private void fill_data() {
        for(String animalName : animalNames){
            animals.add(new Animal(animalsImages.get(animalNames.indexOf(animalName)), animalName, false));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab:
                Intent intent = new Intent(this, SecondActivity.class);
                int position = getListView().getCheckedItemPosition();
                if (position == ListView.INVALID_POSITION) {
                    Toast.makeText(this, "You must choose an animal", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    intent.putExtra("animal", position);
                }
                startActivity(intent);
                break;
        }
    }
}
