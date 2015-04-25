package com.dev.foundingfourfathers.alchemy.DrinkStrategies;

/**
 * Created by alihakimi on 4/24/2015.
 */
public class Drink {
    String name = null;
    boolean selected = false;

    public Drink(String name, boolean selected)
    {
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
