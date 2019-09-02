package com.e.schultetable;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;

public class TableGenerator {
    public Context context;
    private ModelConservation settings;

    ArrayList<ModelItem> items;

    public TableGenerator(Context context) {
        this.context = context;
        this.items = new ArrayList();

        settings = new ModelConservation(context);



        for (int i = 0; i < settings.numberOfColumn*settings.numberOfColumn; i++){
            items.add(new ModelItem(""+i));
        }
        Collections.shuffle(items);

    }

    public int getNumberOfColumn(){
        return settings.numberOfColumn;
    }

    public GridViewAdapter getGridAdapter(){
        return new GridViewAdapter(context, items, settings);
    }
}
