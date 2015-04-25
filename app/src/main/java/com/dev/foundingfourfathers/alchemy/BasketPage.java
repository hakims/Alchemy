package com.dev.foundingfourfathers.alchemy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.foundingfourfathers.alchemy.DrinkStrategies.BasketListSingleton;
import com.dev.foundingfourfathers.alchemy.DrinkStrategies.Drink;
import com.dev.foundingfourfathers.alchemy.DrinkStrategies.MixedDrink;

import java.util.ArrayList;
import java.util.Observer;


public class BasketPage extends Activity {
    /**
     * The container view which has layout change animations turned on. In this sample, this view
     * is a {@link android.widget.LinearLayout}.
     */

    private ViewGroup mContainerView;

    //in the future use a database instead of this local variable
    private static ArrayList<Drink> basketContents;
    private static ArrayList<MixedDrink> observers;


    public static void addNewIngredient(Drink drink)
    {
        BasketListSingleton basketListSingleton = BasketListSingleton.getBasketListSingleton();
        basketListSingleton.addIngredient(drink);
        updateObservers(drink.getName());
    }

    public static void updateObservers(String newIngredientName)
    {
//        for(MixedDrink observer : observers)
//        {
//            observer.update(newIngredientName);
//        }
    }

    public static void addObserver(MixedDrink mixedDrink)
    {
//        observers = new ArrayList<MixedDrink>();
//        observers.add(mixedDrink);
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

         BasketListSingleton basketListSingleton = BasketListSingleton.getBasketListSingleton();
        basketContents = basketListSingleton.getBasketContents();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_drinkselector, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case android.R.id.home:
                // Navigate "up" the demo structure to the launchpad activity.
                // See http://developer.android.com/design/patterns/navigation.html for more.
                NavUtils.navigateUpTo(this, new Intent(this, HomePage.class));
                return true;

            case R.id.hardAlcohol:
//                Toast.makeText(getApplicationContext(), "Hard Alcohol!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(BasketPage.this, ListViewCheckboxesActivity.class);
                intent.putExtra("DRINK_TYPE","hard");
                startActivity(intent);
                Log.i("INTENT_TEST","I made it");
                return true;
            case R.id.lightAlcohol:
                Log.i("INTENT_TEST","light alcohol");
                intent = new Intent(BasketPage.this, ListViewCheckboxesActivity.class);
                intent.putExtra("DRINK_TYPE","light");
                startActivity(intent);
                return true;
            case R.id.mixer:
                intent = new Intent(BasketPage.this, ListViewCheckboxesActivity.class);
                intent.putExtra("DRINK_TYPE","mixer");
                startActivity(intent);
                return true;
            case R.id.liqueur:
                intent = new Intent(BasketPage.this, ListViewCheckboxesActivity.class);
                intent.putExtra("DRINK_TYPE","liqueur");
                startActivity(intent);
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }








}