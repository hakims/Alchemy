package com.dev.foundingfourfathers.alchemy.DrinkStrategies;

import java.util.ArrayList;

/**
 * Created by alihakimi on 4/24/2015.
 */
public class LightAlcoholStrategy extends DrinkStrategy {
    private String[] lightAlcohols = {"Beer", "Red Wine", "White Wine", "Cider", "Champagne"};
    private ArrayList<Drink> drinkList = null;

    public ArrayList<Drink> getDrinkList()
    {
        drinkList = new ArrayList<Drink>();

        Drink drink;
        for(int i =0; i< lightAlcohols.length;i++ )
        {
            drink = new Drink(lightAlcohols[i], false);
            drinkList.add(drink);
        }

        return drinkList;

    }
}
