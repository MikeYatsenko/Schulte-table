package com.e.schultetable;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.ArrayList;

public class TableGenerator {
    public Context context;
    private int numberOfColumn;
    ArrayList<ModelItem> items;

    public TableGenerator(Context context) {
        this.context = context;
        this.items = new ArrayList();

        SharedPreferences sp;
        sp = PreferenceManager.getDefaultSharedPreferences(context);
        numberOfColumn = Integer.parseInt(sp.getString("size", "-1"));
//        Log.e("pref-mix", ""+sp.getBoolean("mix", false));
//        Log.e("pref-hide", ""+sp.getBoolean("hide", false));
//        Log.e("pref-switchingMethod", ""+sp.getBoolean("switchingMethod", false));
//        Log.e("pref-textColor", ""+sp.getBoolean("textColor", false));
//        Log.e("pref-bgColor", ""+sp.getBoolean("bgColor", false));
//        Log.e("pref-animText", ""+sp.getBoolean("animText", false));
//        Log.e("pref-rotItem", ""+sp.getBoolean("rotItem", false));

        for (int i = 0; i < numberOfColumn*numberOfColumn; i++){
            items.add(new ModelItem(""+i));
        }


    }

    public int getNumberOfColumn(){
        return numberOfColumn;
    }

    public GridViewAdapter getGridAdapter(){
        return new GridViewAdapter(context, items);
    }
}
