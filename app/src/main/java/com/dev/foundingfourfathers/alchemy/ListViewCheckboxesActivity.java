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

import java.util.ArrayList;

/**
 * Created by Chris on 4/24/15.
 */
public class ListViewCheckboxesActivity extends Activity {


    DrinkAdapter dataAdapter = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        //Generate list View from ArrayList
        displayListView();

        checkButtonClick();

    }

    private void displayListView() {

        //Array list of hard alcohols
        ArrayList<HardAlcohol> hardAlcoholList = new ArrayList<HardAlcohol>();

        HardAlcohol alcohol = new HardAlcohol("Rum",false);
        hardAlcoholList.add(alcohol);

        alcohol = new HardAlcohol("Tequila",false);
        hardAlcoholList.add(alcohol);

        alcohol = new HardAlcohol("Vodka",false);
        hardAlcoholList.add(alcohol);

        alcohol = new HardAlcohol("Whiskey",false);
        hardAlcoholList.add(alcohol);


        //create an ArrayAdapter from the String Array
        dataAdapter = new DrinkAdapter(this,
                R.layout.hard_alcohol_info, hardAlcoholList);
        ListView listView = (ListView) findViewById(R.id.hardAlcoholListView);
//        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                HardAlcohol alcohol = (HardAlcohol) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                        "Clicked on Row: " + alcohol.getName(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    private class DrinkAdapter extends ArrayAdapter<HardAlcohol> {

        private ArrayList<HardAlcohol> hardAlcoholList;
        public DrinkAdapter(Context context, int textViewResourceId,
                               ArrayList<HardAlcohol> hardAlcoholList) {
            super(context, textViewResourceId, hardAlcoholList);
            this.hardAlcoholList = new ArrayList<HardAlcohol>();
            this.hardAlcoholList.addAll(this.hardAlcoholList);

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
                convertView = vi.inflate(R.layout.hard_alcohol_info, null);

                holder = new ViewHolder();
//                holder.code = (TextView) convertView.findViewById(R.id.code);
                holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
                convertView.setTag(holder);

                holder.name.setOnClickListener( new View.OnClickListener() {
                    public void onClick(View v) {
                        CheckBox cb = (CheckBox) v ;
                        HardAlcohol alcohol = (HardAlcohol) cb.getTag();
                        Toast.makeText(getApplicationContext(),
                                "Clicked on Checkbox: " + cb.getText() +
                                        " is " + cb.isChecked(),
                                Toast.LENGTH_LONG).show();
                        alcohol.setSelected(cb.isChecked());
                    }
                });
            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }

            HardAlcohol alcohol = hardAlcoholList.get(position);
//            holder.code.setText(" (" +  country.getCode() + ")");
            holder.name.setText(alcohol.getName());
            holder.name.setChecked(alcohol.isSelected());
            holder.name.setTag(alcohol);

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

                ArrayList<HardAlcohol> hardAlcoholList = dataAdapter.hardAlcoholList;
                for(int i=0;i<hardAlcoholList.size();i++){
                    HardAlcohol alcohol = hardAlcoholList.get(i);
                    if(alcohol.isSelected()){
                        responseText.append("\n" + alcohol.getName());
                    }
                }

                Toast.makeText(getApplicationContext(),
                        responseText, Toast.LENGTH_LONG).show();

            }
        });

    }

}