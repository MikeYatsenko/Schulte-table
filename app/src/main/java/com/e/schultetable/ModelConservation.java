package com.e.schultetable;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class ModelConservation {
    Context context;
    public int numberOfColumn;
    public boolean shuffleCollection;
    public boolean hidingElements;
    public boolean switchingMethod;
    public boolean textColor;
    public boolean bgColor;
    public boolean animText;
    public boolean rotItem;

    public ModelConservation(Context context) {
        this.context = context;
        SharedPreferences sp;
        sp = PreferenceManager.getDefaultSharedPreferences(context);
        numberOfColumn = Integer.parseInt(sp.getString("size", "-1"));
        shuffleCollection = sp.getBoolean("mix", false);
        hidingElements = sp.getBoolean("hide", false);
        switchingMethod = sp.getBoolean("switchingMethod", false);

        textColor = sp.getBoolean("textColor", false);
        bgColor = sp.getBoolean("bgColor", false);
        animText = sp.getBoolean("animText", false);
        rotItem = sp.getBoolean("rotItem", false);

    }
}
