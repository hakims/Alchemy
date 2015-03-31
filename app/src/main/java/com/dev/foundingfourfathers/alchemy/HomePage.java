package com.dev.foundingfourfathers.alchemy;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import io.realm.RealmObject;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;


public class HomePage extends ActionBarActivity {

    AlchemyDB database;
    private Button b_toBasket;
    private Button dbTest;
    private Button b_make_drink;
    ImageView logo;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        database = new AlchemyDB(getApplicationContext());

        logo = (ImageView) findViewById(R.id.image_logo);
        logo.setImageResource(R.drawable.alchemy_logo);


       //comment this line out for production versions of the Database
       Realm.deleteRealmFile(this);


        b_toBasket = (Button) findViewById(R.id.b_toBasket);
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
                Intent myIntent = new Intent(view.getContext(), LayoutChangesActivity.class);
                //startActivityForResult(myIntent, 0);
                startActivity(myIntent);

            }
        });


        dbTest = (Button) findViewById(R.id.b_dbTest);
        dbTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.insertAlcohol("Absolut Vodka");
                String temp = database.getAllAlcohols();

                Realm realm = Realm.getInstance(getApplicationContext());
                realm.beginTransaction();
                Alcohol testBooze = realm.createObject(Alcohol.class);
                testBooze.setType("Beer");
               // Alcohol testBooze1 = realm.createObject(Whiskey.class);
                realm.commitTransaction();

                Log.i(getClass().getSimpleName(), "Path: " + realm.getPath());

                RealmQuery<Alcohol> query = realm.where(Alcohol.class);
                RealmResults<Alcohol> result = query.findAll();

                //RealmResults will be size 0 if the query finds no matches
                if(result.size() != 0)
                {
                    for(Alcohol alcohol: result)
                    {
                        String boozeType = alcohol.getType();
                        Log.i(getClass().getSimpleName(), "Booze: " + boozeType);
                        Toast.makeText(getApplicationContext(), "RealmDB Test Should return:  " + boozeType, Toast.LENGTH_LONG).show();
                    }
                }

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
