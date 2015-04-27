package com.dev.foundingfourfathers.alchemy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.dev.foundingfourfathers.alchemy.BrowseCocktails.FragmentTransitionFragment;


/**
 * Created by alihakimi on 4/27/2015.
 */
public class PossibleDrinksActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_possible_drinks);

        android.app.ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            PossibleDrinksTransitionFragment fragment = new PossibleDrinksTransitionFragment();
            transaction.replace(R.id.possible_drinks_fragment, fragment);
            transaction.commit();
        }
    }

    //go back to homepage if menu clicked
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, HomePage.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
