package com.dev.foundingfourfathers.alchemy.DrinkStrategies;

import java.util.ArrayList;

/**
 * Created by alihakimi on 4/24/2015.
 */
public class LiqueurStrategy extends DrinkStrategy {
    private String[] liqueurs = {"Baileys", "Schnapps", "Brandy", "Kahlua"};
    private ArrayList<Drink> drinkList = null;

    public ArrayList<Drink> getDrinkList()
    {
        drinkList = new ArrayList<Drink>();

        Drink drink;
        for(int i =0; i< liqueurs.length;i++ )
        {
            drink = new Drink(liqueurs[i], false);
            drinkList.add(drink);
        }

        return drinkList;

    }
}
