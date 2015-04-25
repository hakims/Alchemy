package com.dev.foundingfourfathers.alchemy.DrinkStrategies;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by alihakimi on 4/24/2015.
 */
public class MixerStrategy extends DrinkStrategy {

    private String[] mixers = {"Orange Juice", "Tonic Water", "Coke", "Sprite", "Mountain Dew", "Sour Mix", "Red Bull", "Pineapple Juice", "Cranberry Juice", "Tomato Juice", "Milk", "Lemonade", "Limeade"};
    private ArrayList<Drink> drinkList = null;

    public ArrayList<Drink> getDrinkList()
    {
        Log.i("INTENT_TEST", "I made it to Mixer Strategy");
        drinkList = new ArrayList<Drink>();

        Drink drink;
        for(int i =0; i< mixers.length;i++ )
        {
            drink = new Drink(mixers[i], false);
            drinkList.add(drink);
        }

        return drinkList;

    }
}
