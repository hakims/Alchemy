package com.dev.foundingfourfathers.alchemy;

import java.util.Locale;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class PossibleDrinks extends ActionBarActivity{

    private Button b_toBasket;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_possible_drinks);

        b_toBasket = (Button) findViewById(R.id.b_toBasket);
        b_toBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), BasketPage.class);
                startActivityForResult(myIntent, 0);
            }
        });


    }
}
