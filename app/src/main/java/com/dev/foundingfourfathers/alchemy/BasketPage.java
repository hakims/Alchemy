package com.dev.foundingfourfathers.alchemy;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.dev.foundingfourfathers.alchemy.DrinkStrategies.BasketListSingleton;
import com.dev.foundingfourfathers.alchemy.DrinkStrategies.Drink;
import com.dev.foundingfourfathers.alchemy.DrinkStrategies.MixedDrink;
import com.dev.foundingfourfathers.alchemy.DrinkStrategies.MixedDrinkListSingleton;

import java.util.ArrayList;


public class BasketPage extends ListActivity {
    /**
     * The container view which has layout change animations turned on. In this sample, this view
     * is a {@link android.widget.LinearLayout}.
     */

    //in the future use a database instead of this local variable
    private static ArrayList<Drink> basketContents;
    private static ArrayList<MixedDrink> observers;

    protected static final int CONTEXTMENU_OPTION1 = 1;
    protected static final int CONTEXTMENU_OPTION2 = 2;

    ArrayList<String> listItems=new ArrayList<String>();

    ListView listView = null;


//    private ListView listView = null;

    private Button b_home;

    @Override
    public void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket_page);

        ActionBar actionBar = getActionBar();
//        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        //get current items in basket
        BasketListSingleton basketListSingleton = BasketListSingleton.getBasketListSingleton();
        basketContents = basketListSingleton.getBasketContents();

        //Define a String adapter
        listItems=new ArrayList<String>();
        ArrayAdapter<String> basketListAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listItems);

        //add every item in the basket to the adapter in order to display it on the listView
        for(int i =0; i < basketContents.size(); i++){
            listItems.add(basketContents.get(i).getName());
        }
        setListAdapter(basketListAdapter);

        listView = getListView();
        registerForContextMenu(listView);




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openContextMenu(view);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_drinkselector, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        // Set title for the context menu
        menu.setHeaderTitle("Are you sure you want to remove?");

        // Add all the menu options
        menu.add(Menu.NONE, CONTEXTMENU_OPTION1, 0, "Yes");
        menu.add(Menu.NONE, CONTEXTMENU_OPTION2, 1, "No");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        // Get extra info about list item that was long-pressed
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

        // Perform action according to selected item from context menu
        switch (item.getItemId()) {

            case CONTEXTMENU_OPTION1:
//                ListViewCheckboxesActivity instance = new ListViewCheckboxesActivity();
//                ListViewCheckboxesActivity.DrinkAdapter myDataAdapter = instance.dataAdapter;
//                myDataAdapter.remove(myDataAdapter.getItem(menuInfo.position));
                listItems.remove(menuInfo.position);

                Drink drinkToRemove = basketContents.get(menuInfo.position);
               // basketContents.remove(drinkToRemove);
                BasketListSingleton.removeIngredient(drinkToRemove);


                onCreate(new Bundle());
                break;

            case CONTEXTMENU_OPTION2:
                break;
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case android.R.id.home:
                // Navigate "up" the demo structure to the launchpad activity.
                // See http://developer.android.com/design/patterns/navigation.html for more.
//                NavUtils.navigateUpTo(this, new Intent(this, HomePage.class));
                Intent intent = new Intent(this, HomePage.class);
                startActivity(intent);
                return true;

            case R.id.hardAlcohol:
//                Toast.makeText(getApplicationContext(), "Hard Alcohol!!", Toast.LENGTH_SHORT).show();
                intent = new Intent(BasketPage.this, ListViewCheckboxesActivity.class);
                intent.putExtra("DRINK_TYPE","hard");
                startActivity(intent);
                Log.i("INTENT_TEST","I made it");
                return true;
            case R.id.lightAlcohol:
                Log.i("INTENT_TEST","light alcohol");
                intent = new Intent(BasketPage.this, ListViewCheckboxesActivity.class);
                intent.putExtra("DRINK_TYPE","light");
                startActivity(intent);
                return true;
            case R.id.mixer:
                intent = new Intent(BasketPage.this, ListViewCheckboxesActivity.class);
                intent.putExtra("DRINK_TYPE","mixer");
                startActivity(intent);
                return true;
            case R.id.liqueur:
                intent = new Intent(BasketPage.this, ListViewCheckboxesActivity.class);
                intent.putExtra("DRINK_TYPE","liqueur");
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

//    public static void addNewIngredient(Drink drink)
//    {
//        BasketListSingleton basketListSingleton = BasketListSingleton.getBasketListSingleton();
//        basketListSingleton.addIngredient(drink);
//        //updateObservers(drink.getName());
//
//    }
//
//    public static void removeIngredient(Drink drink)
//    {
//        BasketListSingleton basketListSingleton = BasketListSingleton.getBasketListSingleton();
//        basketListSingleton.removeIngredient(drink);
//        //updateObservers(drink.getName());
//
//    }
//
//    public static void updateObservers(String newIngredientName)
//    {
//     //   observers = MixedDrinkListSingleton.getMixedDrinkListSingleton().getMixedDrinksList();
//
////        for(MixedDrink observer : MixedDrinkListSingleton.getMixedDrinkListSingleton().getMixedDrinksList())
////        {
////            observer.update(newIngredientName);
////        }
//    }






}