package com.dev.foundingfourfathers.alchemy;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;


public class HomePage extends Activity {

    AlchemyDB database;
    private Button b_toBasket;
    private Button dbTest;
    private Button b_make_drink;
    private Button b_to_Spinner;
    ImageView logo;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        database = new AlchemyDB(getApplicationContext());

        logo = (ImageView) findViewById(R.id.image_logo);
        logo.setImageResource(R.drawable.alchemy_logo);



        b_toBasket = (Button) findViewById(R.id.b_toBasket);
        b_toBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), BasketPage.class);
                startActivityForResult(myIntent, 0);
            }
        });

        b_to_Spinner = (Button) findViewById(R.id.b_to_Spinner);
        b_to_Spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), SpinnerTest.class);
                startActivityForResult(myIntent, 0);
            }
        });

        b_make_drink = (Button) findViewById(R.id.button_make_drink);
        b_make_drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), LayoutChangesActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });


        dbTest = (Button) findViewById(R.id.b_dbTest);
        dbTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.insertAlcohol("Absolut Vodka");
                String temp = database.getAllAlcohols();


                Toast.makeText(getApplicationContext(),"First thing in alcohol list is: " + temp, Toast.LENGTH_LONG).show();

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
