package com.dev.foundingfourfathers.alchemy.DrinkStrategies;


import android.util.Log;

import java.util.ArrayList;

/**
 * Created by alihakimi on 4/24/2015.
 */
public abstract class DrinkStrategy {

    public ArrayList<Drink> getDrinkList(){

        ArrayList<Drink> drinkList = null;

        Log.i("INTENT_TEST", "I made it to generic drinkStrategy");
        return drinkList;
    }


}
