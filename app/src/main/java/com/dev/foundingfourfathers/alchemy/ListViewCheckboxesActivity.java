package com.dev.foundingfourfathers.alchemy;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import com.dev.foundingfourfathers.alchemy.DrinkStrategies.Drink;
import com.dev.foundingfourfathers.alchemy.DrinkStrategies.DrinkStrategy;
import com.dev.foundingfourfathers.alchemy.DrinkStrategies.DrinkStrategyFactory;
import com.dev.foundingfourfathers.alchemy.DrinkStrategies.HardAlcohol;

import java.util.ArrayList;

/**
 * Created by Chris on 4/24/15.
 */
public class ListViewCheckboxesActivity extends Activity {

    DrinkAdapter dataAdapter = null;
    String drinkType = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

       Log.i("INTENT_TEST", "I made it 2");
       drinkType = getIntent().getStringExtra("DRINK_TYPE");
        Log.i("INTENT_TEST", "I made it 3");
        Log.i("INTENT_TEST", "Drink type " + drinkType);

        //Generate list View from ArrayList
        displayListView();

        checkButtonClick();

    }

    private void displayListView() {

        DrinkStrategyFactory drinkStrategyFactory = new DrinkStrategyFactory(drinkType);

        Log.i("INTENT_TEST", "Before call to getStrategy");

        DrinkStrategy drinkStrategy = drinkStrategyFactory.getStrategy();

        Log.i("INTENT_TEST", "after getStrategy");

        //Array list of hard alcohols
        ArrayList<Drink> drinkList = drinkStrategy.getDrinkList();

        Log.i("INTENT_TEST", "Hello again");
        Log.i("INTENT_TEST", drinkList.get(0).getName());

        //create an ArrayAdapter from the String Array
        dataAdapter = new DrinkAdapter(this,
                R.layout.drink_info, drinkList);
        ListView listView = (ListView) findViewById(R.id.hardAlcoholListView);
//        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);



    }

    private class DrinkAdapter extends ArrayAdapter<Drink> {

        private ArrayList<Drink> drinkList;

        public DrinkAdapter(Context context, int textViewResourceId,
                               ArrayList<Drink> drinkList)
        {
            super(context, textViewResourceId, drinkList);
            this.drinkList = new ArrayList<Drink>();
            this.drinkList.addAll(drinkList);

        }
        private class ViewHolder {
//            TextView code;
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
//                holder.code = (TextView) convertView.findViewById(R.id.code);
                holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
                convertView.setTag(holder);

                holder.name.setOnClickListener( new View.OnClickListener() {
                    public void onClick(View v) {
                        CheckBox cb = (CheckBox) v ;
                        Drink drink = (Drink) cb.getTag();
//                        Toast.makeText(getApplicationContext(),
//                                "Clicked on Checkbox: " + cb.getText() +
//                                        " is " + cb.isChecked(),
//                                Toast.LENGTH_LONG).show();
                        drink.setSelected(cb.isChecked());
                    }
                });
            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }

            Drink thisDrink = drinkList.get(position);
//            holder.code.setText(" (" +  country.getCode() + ")");
            holder.name.setText(thisDrink.getName());
            holder.name.setChecked(thisDrink.isSelected());
            holder.name.setTag(thisDrink);

            return convertView;

        }

    }

    private void checkButtonClick() {


        Button myButton = (Button) findViewById(R.id.findSelected);



        myButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                StringBuffer responseText = new StringBuffer();
                responseText.append("The following were selected...\n");

                ArrayList<Drink> drinkList = dataAdapter.drinkList;
                for(int i=0;i<drinkList.size();i++)
                {
                    Drink thisDrink = drinkList.get(i);
                    BasketPage.addNewIngredient(thisDrink);

                    //intent stuff to basketpage

                    if(thisDrink.isSelected()){
                        responseText.append("\n" + (thisDrink.getName()));
                    }
                }


                Toast.makeText(getApplicationContext(),
                        responseText, Toast.LENGTH_LONG).show();




            }
        });

    }

}