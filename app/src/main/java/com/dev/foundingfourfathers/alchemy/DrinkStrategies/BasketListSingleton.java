package com.dev.foundingfourfathers.alchemy.DrinkStrategies;

import java.util.ArrayList;

/**
 * Created by alihakimi on 4/25/2015.
 *
 * Singleton object
 */
public class BasketListSingleton {

    private static ArrayList<Drink> basketContents = null;

    private BasketListSingleton() {}

    private static BasketListSingleton basketListSingleton;
    public static BasketListSingleton getBasketListSingleton()
    {
        if(basketListSingleton == null)
        {
            basketListSingleton = new BasketListSingleton();
            basketContents = new ArrayList<Drink>();
        }
        return basketListSingleton;
    }

    public void addIngredient(Drink drink)
    {
        basketContents.add(drink);
    }

    public ArrayList<Drink> getBasketContents()
    {
        return basketContents;
    }


}
