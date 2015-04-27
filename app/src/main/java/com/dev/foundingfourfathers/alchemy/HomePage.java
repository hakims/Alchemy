package com.dev.foundingfourfathers.alchemy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.dev.foundingfourfathers.alchemy.BrowseCocktails.BrowseCocktails;
import com.dev.foundingfourfathers.alchemy.DrinkStrategies.MixedDrink;
import com.dev.foundingfourfathers.alchemy.DrinkStrategies.MixedDrinkListSingleton;


public class HomePage extends Activity {

    AlchemyDB database;
    private ImageButton b_toBasket;
    private Button dbTest;
    private Button b_make_drink;

    private Button b_toBrowseCocktails;
    ImageView logo;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        MixedDrink[] mixedDrinks = MixedDrink.ALL_MIXED_DRINKS;

        database = new AlchemyDB(getApplicationContext());

        logo = (ImageView) findViewById(R.id.image_logo);
        logo.setImageResource(R.drawable.alchemy_logo);



        b_toBasket = (ImageButton) findViewById(R.id.b_toBasket);
        b_toBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), BasketPage.class);
                startActivityForResult(myIntent, 0);
            }
        });



        b_make_drink = (Button) findViewById(R.id.button_make_drink);
        b_make_drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), PossibleDrinksActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });

        b_toBrowseCocktails = (Button) findViewById(R.id.b_toBrowseCocktails);
        b_toBrowseCocktails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), BrowseCocktails.class);
                startActivityForResult(myIntent, 0);
            }
        });

        dbTest = (Button) findViewById(R.id.b_dbTest);
        dbTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // database.insertAlcohol("Absolut Vodka");
               // String temp = database.getAllAlcohols();
               // Toast.makeText(getApplicationContext(),"First thing in alcohol list is: " + temp, Toast.LENGTH_LONG).show();

                MixedDrinkListSingleton mixedDrinkListSingleton = MixedDrinkListSingleton.getMixedDrinkListSingleton();
//                ArrayList<Drink> ingredients = new ArrayList<Drink>();
//                Drink tempDrink = new Drink("Vodka", false);
//                ingredients.add(tempDrink);
//                tempDrink = new Drink("Orange Juice", false);
//                ingredients.add(tempDrink);
//                MixedDrink screwdriver = new MixedDrink("Screwdriver", ingredients);

               // mixedDrinkListSingleton.addMixedDrink(screwdriver);

                Toast.makeText(getApplicationContext(),"Observers: " + mixedDrinkListSingleton.printMixedDrinksList() + "Ingredients: " + mixedDrinkListSingleton.getMixedDrinksList().get(0).printIngredients(), Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
