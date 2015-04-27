package com.dev.foundingfourfathers.alchemy.DrinkStrategies;

import android.util.Log;

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
        Log.i("OBSERVER_TEST", "Added Ingredient to basket : " + printBasketContents() );

        for(MixedDrink observer : MixedDrinkListSingleton.getMixedDrinkListSingleton().getMixedDrinksList())
        {
            observer.updateAfterAdd(drink.getName());
        }


    }
    public static void removeIngredient(Drink drink)
    {
        basketContents.remove(drink);
        Log.i("OBSERVER_TEST", "Removed Ingredient from basket : " + printBasketContents() );

        for(MixedDrink observer : MixedDrinkListSingleton.getMixedDrinkListSingleton().getMixedDrinksList())
        {
            observer.updateAfterRemove(drink.getName());
        }


    }

    public ArrayList<Drink> getBasketContents()
    {
        return basketContents;
    }

    public static String printBasketContents()
    {
        String temp = "";

        for(Drink drink : basketContents)
        {
            temp += drink.getName() + " ";
        }
        return temp;
    }


}
