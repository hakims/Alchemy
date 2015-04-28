/*
 * Copyright 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dev.foundingfourfathers.alchemy.BrowseCocktails;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.foundingfourfathers.alchemy.R;
//import com.example.android.common.logger.Log;

public class DetailFragment extends Fragment implements Animation.AnimationListener {

    private static final String TAG = "DetailFragment";

    private static final String ARG_RESOURCE_ID = "resource_id";
    private static final String ARG_TITLE = "title";
    private static final String ARG_X = "x";
    private static final String ARG_Y = "y";
    private static final String ARG_WIDTH = "width";
    private static final String ARG_HEIGHT = "height";

    public static String DRINK = "";

    /**
     * Create a new instance of DetailFragment.
     *
     * @param resourceId The resource ID of the Drawable image to show
     * @param title The title of the image
     * @param x The horizontal position of the grid item in pixel
     * @param y The vertical position of the grid item in pixel
     * @param width The width of the grid item in pixel
     * @param height The height of the grid item in pixel
     * @return a new instance of DetailFragment
     */
    public static DetailFragment newInstance(int resourceId, String title,
                                             int x, int y, int width, int height) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_RESOURCE_ID, resourceId);
        args.putString(ARG_TITLE, title);
        args.putInt(ARG_X, x);
        args.putInt(ARG_Y, y);
        args.putInt(ARG_WIDTH, width);
        args.putInt(ARG_HEIGHT, height);
        fragment.setArguments(args);

        DRINK = title;

        return fragment;

    }

    public DetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View myInflatedView = inflater.inflate(R.layout.fragment_detail_content, container,false);

        return myInflatedView;
    }

    public void setText(String drinkName){
        TextView textView = (TextView) getView().findViewById(R.id.body);

        Log.i("Drink", "Drink name: " + drinkName);

        //Hard coded strings are added below until we get our database working

        String mojitoRecipe = "Ingredients:\n• 2 parts Light Rum\n• 1 part Simple Syrup\n" +
                "• 1 part Lime Juice\n• 2 parts Club Soda\n• 6 Mint Leaves\n\nGlass:\n• Highball\n\n" +
                "Garnish:\n• Lime\n\nDirections:\n• Muddle (crush) the Mint Leaves in shaker.\n" +
                "• Add Simple Syrup, Lime Juice, and Light Rum to shaker and fill with ice.\n" +
                "• Shake well and pour unstrained into glass.\n" +
                "• Top with Club Soda and garnish.";
        String hurricaneRecipe = "Ingredients:\n• 1 part Vodka\n" +
                "• 1 part Gin\n" +
                "• 1 part Light Rum\n" +
                "• 1/2 part Dark Rum\n" +
                "• 1 part Almond Liqueur \n" +
                "• 1 part Triple Sec\n" +
                "• Grapefruit Juice\n" +
                "• Pineapple Juice\n" +
                "• Grenadine Syrup\n\n" +
                "Glass Type:\n• Hurricane\n\n" +
                "Garnish:\n• Pineapple\n\n" +
                "Directions:\n• Pour all alcohols into glass, 3/4 filled with ice.\n" +
                "• Fill with equal parts of Grapefruit Juice and Pineapple Juice.\n" +
                "• Add dash of Grenadine Syrup, stir, and garnish.";

        String rumAndCokeRecipe = "Ingredients:\n• 2 parts Dark Rum\n• Coke\n\n" +
                "Glass:\n• Rocks\n\n" +
                "Garnish:\n• Lime\n\n" +
                "Directions:\n• Fill glass with ice.\n" +
                "• Add Rum, top with Coke, and garnish.";

        String bayBreezeRecipe = "Ingredients:\n• 3 parts Vodka\n" +
                "• 1 part Cranberry Juice\n" +
                "• 1 part Pineapple Juice\n\n" +
                "Glass:\n• Highball\n\n" +
                "Garnish:\n• Lime\n\n" +
                "Directions:\n• Combine all ingredients in glass with ice.\n" +
                "• Garnish.\n\n" +
                "Note:\n" +
                "• Sub Vodka with Coconut Rum for Malibu Bay Breeze.";

        String bloodyMaryRecipe = "Ingredients:\n• 3 parts Vodka\n" +
                "• 6 parts Tomato Juice\n" +
                "• 1 part Lemon Juice\n" +
                "• Salt and Pepper\n" +
                "• Hot Sauce\n" +
                "• Worchestershire Sauce\n\n" +
                "Glass:\n• Highball\n\n" +
                "Garnish:\n• Celery Stalk\n" +
                "• Lemon\n\n" +
                "Directions:\n• Add dashes of Worchestershire Sauce, Tobasco, Salt, and Pepper into glass.\n" +
                "• Pour all other ingredients into glass.\n" +
                "• Add ice and stir gently.\n" +
                "• Garnish.";

        String darkAndStormyRecipe = "Ingredients:\n• 1 part Dark Rum\n" +
                "• 2 parts Ginger Beer\n\n" +
                "Glass:\n• Old Fashioned\n\n" +
                "Garnish:\n• Lime\n\n" +
                "Directions:\n• Pour Dark Rum over ice in glass.\n" +
                "• Top with ginger beer. \n" +
                "• Garnish.";

        String frozenMargaritaRecipe = "Ingredients:\n• 3 parts White Tequila\n" +
                "• 1 part Triple Sec\n" +
                "• 2 parts Lime Juice\n" +
                "• Crushed Ice\n" +
                "• Salt\n\n" +
                "Glass:\n• Margarita or Cocktail\n\n" +
                "Garnish:\n• Lime\n\n" +
                "Directions:\n• Pour Tequila, Triple Sec, Lime Juice, and Crushed Ice into blender.\n" +
                "• Blend well on high speed\n" +
                "• Rub rim of glass with lime wedge, and dip glass into Salt to coat rim. \n" +
                "• Pour blended mix into glass.\n\n" +
                "Note:\n• Can add different fruits before blending for fruity Margarita.";

        String longIslandIcedTeaRecipe = "Ingredients:\n• 1 part Vodka\n" +
                "• 1 part Tequila\n" +
                "• 1 part Light Rum\n" +
                "• 1 part Gin\n" +
                "• 1 part Triple Sec\n" +
                "• 1.5 part Sour mix\n" +
                "• 1 splash Coke\n\n" +
                "Glass:\n• Highball\n\n" +
                "Garnish:\n• Lemon\n\n" +
                "Directions:\n• Mix ingredients in shaker over ice. \n" +
                "• Pour into glass, adding extra ice as needed.\n" +
                "• Garnish.";

        String moscowMuleRecipe = "Ingredients:\n• 2 parts Vodka\n" +
                "• 3 parts Ginger Beer\n" +
                "• 1 part Lime Juice\n\n" +
                "Glass:\n• Copper Cup\n\n" +
                "Garnish:\n• Lime\n\n" +
                "Directions:\n• Fill glass with ice.\n" +
                "• Add all ingredients to glass and mix.\n" +
                "• Garnish.";

        String pinaColadaRecipe = "Ingredients:\n• 2 parts Light Rum\n" +
                "• 2 parts Coconut Cream\n" +
                "• 2 parts Pineapple Juice\n\n" +
                "Glass:\n• Hurricane\n\n" +
                "Garnish:\n• Cherry and Pineapple\n\n" +
                "Directions:\n• Add all ingredients into blender with crushed ice.\n" +
                "• Blend on high, until well blended. \n" +
                "• Add to glass and garnish.\n\n" +
                "Note:\n• Can be done \"on-the-rocks\" instead of blended.";

        String screwdriverRecipe = "Ingredients:\n• 2 Parts Vodka\n" +
                "• Orange Juice\n\n" +
                "Glass:\n• Highball\n\n" +
                "Garnish:\n• Orange Slice\n\n" +
                "Directions:\n• Fill glass with ice.\n" +
                "• Add Vodka, top with Orange Juice, and garnish.";

        String sevenAndSevenRecipe = "Ingredients:\n• 2 parts Whiskey\n" +
                "• Lemon-Lime Soda\n\n" +
                "Glass:\n• Old Fashioned\n\n" +
                "Garnish:\n• None\n\n" +
                "Directions:\n• Fill glass with ice.\n" +
                "• Add Whiskey and top with Lemon-Lime Soda.\n\n" +
                "Note:\n • Seagram's Seven Whiskey and 7-UP Soda is recommended for this.";

        String ginAndTonicRecipe = "Ingredients:\n• 1 part Gin\n" +
                "• 2 parts Tonic\n\n" +
                "Glass:\n• Highball or Rocks\n\n" +
                "Garnish:\n• Lime\n\n" +
                "Directions:\n• Pour ingredients in glass with ice.\n" +
                "• Mix and garnish.\n\n" +
                "Note:\n• Change amounts to taste.";

        String sexOnTheBeachRecipe = "Ingredients:\n• 2 parts Vodka\n" +
                "• 1 part Peach Schnapps\n" +
                "• 2 parts Cranberry Juice\n" +
                "• 2 parts Orange Juice\n\n" +
                "Glass:\n• Highball\n\n" +
                "Garnish\n• Cherry and Orange Slice\n\n" +
                "Directions:\n• Add all ingredients to glass and mix.\n" +
                "• Fill with ice and garnish.\n\n" +
                "Note:\n• Pineapple Juice can be substituted for Orange Juice";

        String whiskeySourRecipe = "Ingredients:\n• 2 parts Whiskey\n" +
                "• 4 parts Sour Mix\n\n" +
                "Glass:\n• Old Fashioned\n\n" +
                "Garnish\n• Cherry\n\n" +
                "Directions:\n• Combine ingredients in glass.\n" +
                "• Top with ice and garnish.";



        switch (drinkName) {
            case "Mojito":
                textView.setText(mojitoRecipe);
                break;
            case "Hurricane":
                textView.setText(hurricaneRecipe);
                break;
            case "Rum and Coke":
                textView.setText(rumAndCokeRecipe);
                break;
            case "Bay Breeze":
                textView.setText(bayBreezeRecipe);
                break;
            case "Bloody Mary":
                textView.setText(bloodyMaryRecipe);
                break;
            case "Dark and Stormy":
                textView.setText(darkAndStormyRecipe);
                break;
            case "Frozen Margarita":
                textView.setText(frozenMargaritaRecipe);
                break;
            case "Long Island Iced Tea":
                textView.setText(longIslandIcedTeaRecipe);
                break;
            case "Moscow Mule":
                textView.setText(moscowMuleRecipe);
                break;
            case "Pina Colada":
                textView.setText(pinaColadaRecipe);
                break;
            case "Screwdriver":
                textView.setText(screwdriverRecipe);
                break;
            case "Seven and Seven":
                textView.setText(sevenAndSevenRecipe);
                break;
            case "Gin and Tonic":
                textView.setText(ginAndTonicRecipe);
                break;
            case "Sex on the Beach":
                textView.setText(sexOnTheBeachRecipe);
                break;
            case "Whiskey Sour":
                textView.setText(whiskeySourRecipe);
                break;
            default:
                textView.setText("Drink Recipe");
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        FrameLayout root = (FrameLayout) view;
        Context context = view.getContext();
        assert context != null;
        // This is how the fragment looks at first. Since the transition is one-way, we don't need to make
        // this a Scene.
        View item = LayoutInflater.from(context).inflate(R.layout.item_mixed_drink_grid, root, false);
        assert item != null;
        bind(item);
        // We adjust the position of the initial image with LayoutParams using the values supplied
        // as the fragment arguments.
        Bundle args = getArguments();
        FrameLayout.LayoutParams params = null;
        if (args != null) {
            params = new FrameLayout.LayoutParams(
                    args.getInt(ARG_WIDTH), args.getInt(ARG_HEIGHT));
            params.topMargin = args.getInt(ARG_Y);
            params.leftMargin = args.getInt(ARG_X);
        }
        root.addView(item, params);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    /**
     * Bind the views inside of parent with the fragment arguments.
     *
     * @param parent The parent of views to bind.
     */
    private void bind(View parent) {
        Bundle args = getArguments();
        if (args == null) {
            return;
        }
        ImageView image = (ImageView) parent.findViewById(R.id.image);
        image.setImageResource(args.getInt(ARG_RESOURCE_ID));
        TextView title = (TextView) parent.findViewById(R.id.title);
        title.setText(args.getString(ARG_TITLE));
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        Animation animation = AnimationUtils.loadAnimation(getActivity(),
                enter ? android.R.anim.fade_in : android.R.anim.fade_out);
        // We bind a listener for the fragment transaction. We only bind it when
        // this fragment is entering.
        if (animation != null && enter) {
            animation.setAnimationListener(this);
        }
        return animation;
    }

    @Override
    public void onAnimationStart(Animation animation) {
        // This method is called at the end of the animation for the fragment transaction.
        // There is nothing we need to do in this sample.
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        // This method is called at the end of the animation for the fragment transaction,
        // which is perfect time to start our Transition.
        //Log.i(TAG, "Fragment animation ended. Starting a Transition.");

        final Scene scene = Scene.getSceneForLayout((ViewGroup) getView(),
                R.layout.fragment_detail_content, getActivity());
        TransitionManager.go(scene);
        // Note that we need to bind views with data after we call TransitionManager.go().
        bind(scene.getSceneRoot());
        setText(DRINK);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        // This method is never called in this sample because the animation doesn't repeat.
    }

}
