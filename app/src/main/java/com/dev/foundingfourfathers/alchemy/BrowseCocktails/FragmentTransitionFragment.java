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

import com.dev.foundingfourfathers.alchemy.DrinkStrategies.MixedDrink;
import com.dev.foundingfourfathers.alchemy.R;

//import com.example.android.common.logger.Log;

public class FragmentTransitionFragment extends Fragment implements AdapterView.OnItemClickListener {

    private static final String TAG = "FragmentTransitionFragment";

    private DrinkAdapter dAdapter;

    public static FragmentTransitionFragment newInstance() {
        return new FragmentTransitionFragment();
    }

    public FragmentTransitionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // This is the adapter we use to populate the grid.
        dAdapter = new DrinkAdapter(inflater, R.layout.item_mixed_drink_grid);
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
                .replace(R.id.sample_content_fragment,
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
