package com.e.schultetable;

public class ModelItem {
    public String title;
    public boolean visibility;

    public ModelItem(String s) {
        this.title = s;
        this.visibility = true;
    }

    public void invisibility(){
        this.visibility = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }
}
