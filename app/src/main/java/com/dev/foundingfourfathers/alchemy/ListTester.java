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
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.dev.foundingfourfathers.alchemy.DrinkStrategies.BasketListSingleton;
import com.dev.foundingfourfathers.alchemy.DrinkStrategies.Drink;

import java.util.ArrayList;

/**
 * Created by Binka on 4/25/2015.
 */
public class ListTester extends ListActivity {
    //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    ArrayList<String> listItems=new ArrayList<String>();
    ArrayList<Drink> myBasketItems = new ArrayList<Drink>();

    private ViewGroup mContainerView;



    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
    ArrayAdapter<String> adapter;

    //RECORDING HOW MANY TIMES THE BUTTON HAS BEEN CLICKED
    int clickCounter=0;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_basket_page);
        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);

        Drink thisDrink;
        String drinkName;
        BasketListSingleton basketListSingleton = BasketListSingleton.getBasketListSingleton();
        myBasketItems = basketListSingleton.getBasketContents();

        for(int i =0; i < myBasketItems.size(); i++){
            thisDrink = myBasketItems.get(i);
            drinkName = thisDrink.getName();
            listItems.add(drinkName);
        }

        setListAdapter(adapter);

    }

    public void addDrinksToBasket(ArrayList<Drink> myDrinks) {
        for (int i = 0; i < myDrinks.size(); i++) {
            Drink thisDrink = myDrinks.get(i);
            myBasketItems.add(thisDrink);
        }
    }



    //METHOD WHICH WILL HANDLE DYNAMIC INSERTION
    public void addItems(View v) {




        adapter.notifyDataSetChanged();
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
                Intent intent = new Intent(ListTester.this, ListViewCheckboxesActivity.class);
                intent.putExtra("DRINK_TYPE","hard");
                startActivity(intent);
                Log.i("INTENT_TEST", "I made it");
                return true;
            case R.id.lightAlcohol:
                Log.i("INTENT_TEST","light alcohol");
                intent = new Intent(ListTester.this, ListViewCheckboxesActivity.class);
                intent.putExtra("DRINK_TYPE","light");
                startActivity(intent);
                return true;
            case R.id.mixer:
                intent = new Intent(ListTester.this, ListViewCheckboxesActivity.class);
                intent.putExtra("DRINK_TYPE","mixer");
                startActivity(intent);
                return true;
            case R.id.liqueur:
                intent = new Intent(ListTester.this, ListViewCheckboxesActivity.class);
                intent.putExtra("DRINK_TYPE","liqueur");
                startActivity(intent);
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }


}