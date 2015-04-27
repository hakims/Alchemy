package com.dev.foundingfourfathers.alchemy;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import com.dev.foundingfourfathers.alchemy.DrinkStrategies.BasketListSingleton;
import com.dev.foundingfourfathers.alchemy.DrinkStrategies.Drink;
import com.dev.foundingfourfathers.alchemy.DrinkStrategies.DrinkStrategy;
import com.dev.foundingfourfathers.alchemy.DrinkStrategies.DrinkStrategyFactory;

import java.util.ArrayList;

/**
 * Created by Chris on 4/24/15.
 */
public class ListViewCheckboxesActivity extends Activity {

    DrinkAdapter dataAdapter = null;
    String drinkType = null;
    private ViewGroup mContainerView;

    //added this
    ListView listView = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        drinkType = getIntent().getStringExtra("DRINK_TYPE");

        //Generate list View from ArrayList
        displayListView();

        checkButtonClick();

    }

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

    public void onBackPressed() {
        Intent intent = new Intent(this, BasketPage.class);
        startActivity(intent);
    }

    //changed from private
    public void displayListView() {

        DrinkStrategyFactory drinkStrategyFactory = new DrinkStrategyFactory(drinkType);

        DrinkStrategy drinkStrategy = drinkStrategyFactory.getStrategy();

        //Array list of drinks
        ArrayList<Drink> drinkList = drinkStrategy.getDrinkList();

        //create an ArrayAdapter from the String Array
        dataAdapter = new DrinkAdapter(this,
                R.layout.drink_info, drinkList);

        //changed from initializing here to field
        listView = (ListView) findViewById(R.id.drinkListView);
//        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);



    }

    //changed from private
    public class DrinkAdapter extends ArrayAdapter<Drink> {

        //changed from private
        public ArrayList<Drink> drinkList;

        public DrinkAdapter(Context context, int textViewResourceId,
                               ArrayList<Drink> drinkList)
        {
            super(context, textViewResourceId, drinkList);
            this.drinkList = new ArrayList<Drink>();
            this.drinkList.addAll(drinkList);

        }
        private class ViewHolder {
            CheckBox name;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));

            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.drink_info, null);

                holder = new ViewHolder();
                holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
                convertView.setTag(holder);

                holder.name.setOnClickListener( new View.OnClickListener() {
                    public void onClick(View v) {
                        CheckBox cb = (CheckBox) v ;
                        Drink drink = (Drink) cb.getTag();
                        drink.setSelected(cb.isChecked());
                    }
                });
            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }

            Drink thisDrink = drinkList.get(position);
            holder.name.setText(thisDrink.getName());
            holder.name.setChecked(thisDrink.isSelected());
            holder.name.setTag(thisDrink);

            return convertView;

        }

    }

    private void checkButtonClick() {


        Button myButton = (Button) findViewById(R.id.b_add_drink);

        myButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

//                StringBuffer responseText = new StringBuffer();
//                responseText.append("The following were selected...\n");

                ArrayList<Drink> drinkList = dataAdapter.drinkList;
                for(int i=0;i<drinkList.size();i++)
                {
                    Drink thisDrink = drinkList.get(i);


                    //intent stuff to basketpage

                    if(thisDrink.isSelected()){
//                        responseText.append("\n" + (thisDrink.getName()));
                        BasketListSingleton.getBasketListSingleton().addIngredient(thisDrink);
                        dataAdapter.notifyDataSetChanged();
                    }
                }


//                Toast.makeText(getApplicationContext(),
//                        responseText, Toast.LENGTH_LONG).show();

                Intent myIntent = new Intent(v.getContext(), BasketPage.class);
                startActivityForResult(myIntent, 0);




            }
        });

    }

    public void notifyFunction()
    {
        dataAdapter.notifyDataSetChanged();
    }

}