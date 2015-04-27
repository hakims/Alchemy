package com.dev.foundingfourfathers.alchemy.DrinkStrategies;

import java.util.ArrayList;

/**
 * Created by alihakimi on 4/27/2015.
 */
public class MixedDrinkListSingleton {

    private static ArrayList<MixedDrink> mixedDrinks = null;

    private MixedDrinkListSingleton() {}

    private static MixedDrinkListSingleton mixedDrinkListSingleton;
    public static MixedDrinkListSingleton getMixedDrinkListSingleton()
    {
        if(mixedDrinkListSingleton == null)
        {
            mixedDrinkListSingleton = new MixedDrinkListSingleton();
            mixedDrinks = new ArrayList<MixedDrink>();
        }
        return mixedDrinkListSingleton;
    }

    public static void addMixedDrink(MixedDrink mixedDrink)
    {
        mixedDrinks.add(mixedDrink);
    }

    public static void removeMixedDrink(MixedDrink mixedDrink) { mixedDrinks.remove(mixedDrink);}

    public ArrayList<MixedDrink> getMixedDrinksList()
    {
        return mixedDrinks;
    }

    public String printMixedDrinksList()
    {
        String temp = "";

        for(Drink drink : mixedDrinks)
        {
            temp += drink.getName() + " ";
        }
        return temp;
    }

}
