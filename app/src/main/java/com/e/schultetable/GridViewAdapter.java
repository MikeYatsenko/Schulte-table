package com.e.schultetable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GridViewAdapter  extends BaseAdapter {
    private ModelConservation settings;
    private ArrayList<ModelItem> tabItems;
    private Context context;
    Random random;
    public GridViewAdapter(Context context, ArrayList<ModelItem> tabItems, ModelConservation settings) {
        this.settings = settings;
        this.tabItems = tabItems;
        this.context = context;
        this.random = new Random();
    }

    @Override
    public int getCount() {
        return tabItems.size();
    }

    @Override
    public Object getItem(int position) {
        return tabItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private int gatRandColor(){
        int[] rainbow = context.getResources().getIntArray(R.array.rainbow);

        return rainbow[random.nextInt(rainbow.length)];
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            LayoutInflater lInflater = LayoutInflater.from(context);
            convertView = lInflater.inflate(R.layout.grid_view_item, null);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.textView);
        textView.setText(tabItems.get(position).getTitle());
        if(settings.textColor)
            textView.setTextColor(gatRandColor());

        if(settings.bgColor)
            convertView.setBackgroundColor(gatRandColor());

        if (tabItems.get(position).getVisibility()){
            convertView.setVisibility(View.VISIBLE);
        }else{
            convertView.setVisibility(View.INVISIBLE);

        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dataSetChanged(position);
            }
        });
        return (convertView);
    }
    public void dataSetChanged(int position){
        this.notifyDataSetChanged();
        Toast.makeText(context, "" + tabItems.get(position).getTitle(), Toast.LENGTH_SHORT).show();
        if(settings.shuffleCollection)
            (tabItems.get(position)).invisibility();

        if(settings.hidingElements)
            Collections.shuffle(tabItems);
    }
    public void dataSetChanged(){
//        this.notifyDataSetChanged();
//        Toast.makeText(context, "" + tabItems.get(position).getTitle(), Toast.LENGTH_SHORT).show();
//        (tabItems.get(position)).invisibility();
//        if(settings.shuffleCollection)
//            Collections.shuffle(tabItems);
    }
}
