package com.dev.foundingfourfathers.alchemy.DrinkStrategies;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by alihakimi on 4/24/2015.
 */
public class HardAlcoholStrategy extends DrinkStrategy
{
    private String[] hardAlcohols = {"Rum", "Vodka", "Tequila", "Whiskey", "Gin", "Scotch", "Brandy", "Bourboun"};
    private ArrayList<Drink> drinkList = null;

    public ArrayList<Drink> getDrinkList()
    {
        Log.i("INTENT_TEST", "I made it to hardAlcohols");

        drinkList = new ArrayList<Drink>();
        Drink drink;
        for(int i =0; i<hardAlcohols.length;i++ )
        {
            drink = new Drink(hardAlcohols[i], false);
            drinkList.add(drink);
        }

        return drinkList;

    }
}
