package com.zakhar.myturtletask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AnimalsAdapter extends BaseAdapter {

    private Context ctx;
    private LayoutInflater lInflater;
    private List<Animal> objects;
    private RadioButton rbChoice;
    private int selectedIndex = -1;

    public AnimalsAdapter(Context ctx, List<Animal> objects) {
        this.ctx = ctx;
        this.lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.objects = objects;
    }

    public void setSelectedIndex(int index) {
        selectedIndex = index;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.itemforlist, parent, false);
        }
        Animal animal = getAnimal(position);

        ((TextView) view.findViewById(R.id.tvTitle)).setText(animal.name);
        ((ImageView) view.findViewById(R.id.ivImage)).setImageResource(animal.image);
        rbChoice = (RadioButton) view.findViewById(R.id.rbChoice);

        if (selectedIndex == position) {
            rbChoice.setChecked(true);
        } else {
            rbChoice.setChecked(false);
        }
        return view;
    }

    private Animal getAnimal(int position) {
        return ((Animal) getItem(position));
    }
}
