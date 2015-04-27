package com.dev.foundingfourfathers.alchemy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;

import com.dev.foundingfourfathers.alchemy.BrowseCocktails.DetailFragment;
import com.dev.foundingfourfathers.alchemy.DrinkStrategies.MixedDrink;

/**
 * Created by alihakimi on 4/27/2015.
 */
public class PossibleDrinksTransitionFragment extends Fragment implements AdapterView.OnItemClickListener {

    private static final String TAG = "FragmentTransitionFragment";

    private PossibleDrinksAdapter dAdapter;

    public static PossibleDrinksTransitionFragment newInstance() {
        return new PossibleDrinksTransitionFragment();
    }

    public PossibleDrinksTransitionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // This is the adapter we use to populate the grid.
        dAdapter = new PossibleDrinksAdapter(inflater, R.layout.item_mixed_drink_grid);
        // Inflate the layout with a GridView in it.
        return inflater.inflate(R.layout.fragment_fragment_transition, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        GridView grid = (GridView) view.findViewById(R.id.grid);
        grid.setAdapter(dAdapter);
        grid.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        MixedDrink mixedDrink = dAdapter.getItem(position);
        Log.i(TAG, mixedDrink.getName() + " clicked. Replacing fragment.");
        // We start the fragment transaction here. It is just an ordinary fragment transaction.
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.possible_drinks_fragment,
                        DetailFragment.newInstance(mixedDrink.resourceId, mixedDrink.getName(),
                                (int) view.getX(), (int) view.getY(),
                                view.getWidth(), view.getHeight())
                )
                        // We push the fragment transaction to back stack. User can go back to the
                        // previous fragment by pressing back button.
                .addToBackStack("detail")
                .commit();
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return AnimationUtils.loadAnimation(getActivity(),
                enter ? android.R.anim.fade_in : android.R.anim.fade_out);
    }

}
