package com.dev.foundingfourfathers.alchemy;

/**
 * Created by Chris on 4/24/15.
 */
public class HardAlcohol {

    String name = null;
    boolean selected = false;

    public HardAlcohol(String name, boolean selected) {
        super();
        this.name = name;
        this.selected = selected;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isSelected() {
        return selected;
    }
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
