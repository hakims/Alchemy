package com.dev.foundingfourfathers.alchemy;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.dev.foundingfourfathers.alchemy.DrinkStrategies.BasketListSingleton;
import com.dev.foundingfourfathers.alchemy.DrinkStrategies.Drink;
import com.dev.foundingfourfathers.alchemy.DrinkStrategies.MixedDrink;

import java.util.ArrayList;


public class BasketPage extends ListActivity {
    /**
     * The container view which has layout change animations turned on. In this sample, this view
     * is a {@link android.widget.LinearLayout}.
     */

    //in the future use a database instead of this local variable
    private static ArrayList<Drink> basketContents;
    private static ArrayList<MixedDrink> observers;

    private Button b_home;
    private Button b_remove;




    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket_page);

        //get current items in basket
        BasketListSingleton basketListSingleton = BasketListSingleton.getBasketListSingleton();
        basketContents = basketListSingleton.getBasketContents();

        //Define a String adapter
        final ArrayList<String> listItems=new ArrayList<String>();
        ArrayAdapter<String> basketListAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listItems);

        //add every item in the basket to the adapter in order to display it on the listview
        for(int i =0; i < basketContents.size(); i++){
            listItems.add(basketContents.get(i).getName());
        }
        setListAdapter(basketListAdapter);

        b_home = (Button) findViewById(R.id.button_toHome);
        b_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), HomePage.class);
                startActivityForResult(myIntent, 0);
            }
        });

        b_remove = (Button) findViewById(R.id.button_remove);
        b_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListViewCheckboxesActivity instance = new ListViewCheckboxesActivity();
                ListViewCheckboxesActivity.DrinkAdapter myDataAdapter = instance.dataAdapter;
//                final int position = instance.listView.getPositionForView((View) view.getParent());
                int firstPosition = 0;

                Drink firstDrinkInBasket = basketContents.get(firstPosition);
                if (firstDrinkInBasket != null) {
                    basketContents.remove(firstDrinkInBasket);
                    listItems.remove(firstPosition);
//                    instance.notifyFunction();
                }

            }
        });

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


    public static void addNewIngredient(Drink drink)
    {
        BasketListSingleton basketListSingleton = BasketListSingleton.getBasketListSingleton();
        basketListSingleton.addIngredient(drink);
        updateObservers(drink.getName());

//        ListViewCheckboxesActivity instance = new ListViewCheckboxesActivity();
//        instance.dataAdapter.add(drink);
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





}