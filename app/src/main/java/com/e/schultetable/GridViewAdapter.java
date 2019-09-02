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

public class GridViewAdapter  extends BaseAdapter {
    private ArrayList<ModelItem> tabItems;
    private Context context;
    public GridViewAdapter(Context context, ArrayList<ModelItem> tabItems) {
        this.tabItems = tabItems;
        this.context = context;
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

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            LayoutInflater lInflater = LayoutInflater.from(context);
            convertView = lInflater.inflate(R.layout.grid_view_item, null);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.textView);
        textView.setText(tabItems.get(position).getTitle());
        if (tabItems.get(position).getVisibility()){
            convertView.setVisibility(View.VISIBLE);
        }else{
            convertView.setVisibility(View.INVISIBLE);

        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "" + tabItems.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                (tabItems.get(position)).invisibility();
                Collections.shuffle(tabItems);
                dataSetChanged();
            }
        });
        return (convertView);
    }
    public void dataSetChanged(){
        this.notifyDataSetChanged();
    }
}
