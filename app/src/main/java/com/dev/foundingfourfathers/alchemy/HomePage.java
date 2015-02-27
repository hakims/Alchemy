package com.dev.foundingfourfathers.alchemy;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;


public class HomePage extends ActionBarActivity implements ExampleItemFragment.OnFragmentInteractionListener {

    private Button b_toBasket;
    private Button b_toBrowseCocktails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);



    //Initialize Buttons
        b_toBasket = (Button) findViewById(R.id.b_toBasket);
        b_toBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), BasketPage.class);
                startActivityForResult(myIntent, 0);
            }
        });

        b_toBrowseCocktails = (Button) findViewById(R.id.b_browseCocktails);
        b_toBrowseCocktails.setOnClickListener(new View.OnClickListener(){
            @Override
        public void onClick(View view)
            {
                Intent myIntent = new Intent(view.getContext(), BrowseCocktailsPage.class);
                startActivityForResult(myIntent,0);
            }

        });



    }

    public void onFragmentInteraction(String id){

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
