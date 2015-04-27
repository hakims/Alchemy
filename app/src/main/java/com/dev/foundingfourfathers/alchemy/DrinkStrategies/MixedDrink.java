package com.dev.foundingfourfathers.alchemy.DrinkStrategies;

import android.util.Log;
import android.widget.Toast;

import com.dev.foundingfourfathers.alchemy.BasketPage;
import com.dev.foundingfourfathers.alchemy.R;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by alihakimi on 4/25/2015.
 */
public class MixedDrink extends Drink implements Observer {

    private ArrayList<Drink> ingredients;
    private int numAvailableIngredientsInBasket;

    public MixedDrink(String name, ArrayList<Drink> ingredients )
    {
        super(name,false);
        this.ingredients = ingredients;

        //Add this Mixed Drink as an observer
        addObserver(this);
    }

    public ArrayList<Drink> getIngredients()
    {
        return ingredients;
    }

    public int getNumAvailableIngredientsInBasket()
    {
        return numAvailableIngredientsInBasket;
    }

    public void addIngredient(String ingredientName)
    {
        Drink newIngredient = new Drink(ingredientName,false);
        ingredients.add(newIngredient);
    }

    public void updateAfterAdd(String basketItem)
    {
        //if basketItem is in the list of ingredients, update numAvailableIngredients.
        Log.i("OBSERVER_TEST", "Am I here twice? " + numAvailableIngredientsInBasket + " " + basketItem);

        for(Drink ingredient: ingredients)
        {

            if(ingredient.getName().equals(basketItem))
            {
                numAvailableIngredientsInBasket++;
                Log.i("OBSERVER_TEST", "numAvailable update: " + numAvailableIngredientsInBasket);
            }
        }

    }

    public void updateAfterRemove(String basketItem)
    {
        //if basketItem is in the list of ingredients, update numAvailableIngredients.
        for(Drink ingredient: ingredients)
        {
            if(ingredient.getName().equals(basketItem))
            {
                if(numAvailableIngredientsInBasket > 0)
                    numAvailableIngredientsInBasket--;
                Log.i("OBSERVER_TEST", "numAvailable update: " + numAvailableIngredientsInBasket);
            }
        }

    }

    public static void addObserver(MixedDrink mixedDrink)
    {
        MixedDrinkListSingleton mixedDrinkListSingleton = MixedDrinkListSingleton.getMixedDrinkListSingleton();
        mixedDrinkListSingleton.addMixedDrink(mixedDrink);

    }



    //everything below here is used exclusively for the BrowseCocktails

    public int resourceId;

    public MixedDrink(int resourceId, String name) {

        super(name,false);
        this.resourceId = resourceId;
    }

    public static final MixedDrink[] MIXED_DRINKS = {
            new MixedDrink(R.drawable.long_island, "Long Island Ice Tea"),
            new MixedDrink(R.drawable.moscow_mule, "Moscow Mule"),
            new MixedDrink(R.drawable.rum_and_coke, "Rum and Coke"),
            new MixedDrink(R.drawable.screwdriver, "Screwdriver"),
            new MixedDrink(R.drawable.frozen_margarita, "Frozen Margarita"),
            new MixedDrink(R.drawable.hurricane, "Hurricane"),
            new MixedDrink(R.drawable.mojito, "Mojito"),
            new MixedDrink(R.drawable.bay_breeze, "Bay Breeze"),
            new MixedDrink(R.drawable.sex_on_the_beach, "Sex on the Beach"),
            new MixedDrink(R.drawable.dark_and_stormy, "Dark and Stormy"),
            new MixedDrink(R.drawable.bloody_mary, "Bloody Mary"),
            new MixedDrink(R.drawable.gin_and_tonic , "Gin and Tonic" ),
            new MixedDrink(R.drawable.pina_colada , "Pina Colada" ),
            new MixedDrink(R.drawable.seven_and_seven , "Seven and Seven" ),
            new MixedDrink(R.drawable.whiskey_sour, "Whiskey Sour" ),
    };
}

