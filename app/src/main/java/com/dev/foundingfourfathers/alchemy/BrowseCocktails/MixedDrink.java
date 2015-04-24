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

import com.dev.foundingfourfathers.alchemy.R;

/**
 * This represents a sample data.
 */
public class MixedDrink {

    public int resourceId;
    public String title;

    public MixedDrink(int resourceId, String title) {
        this.resourceId = resourceId;
        this.title = title;
    }

    public static final MixedDrink[] MIXED_DRINKS = {
            new MixedDrink(R.drawable.long_island, "Long Island Ice Tea"),
            new MixedDrink(R.drawable.moscow_mule, "Moscow Mule"),
            new MixedDrink(R.drawable.rum_and_coke, "Rum and Coke"),
            new MixedDrink(R.drawable.screwdriver, "Screwdriver"),
            new MixedDrink(R.drawable.frozen_margarita, "Frozen Margarita"),
            new MixedDrink(R.drawable.hurricane, "Hurricane"),
            new MixedDrink(R.drawable.mojito, "Mojito"),
            new MixedDrink(R.drawable.bay_breeze, "Bay Breeze"),
            new MixedDrink(R.drawable.sex_on_the_beach, "Sex on the Beach"),
            new MixedDrink(R.drawable.dark_and_stormy, "Dark and Stormy"),
            new MixedDrink(R.drawable.bloody_mary, "Bloody Mary"),
            new MixedDrink(R.drawable.gin_and_tonic , "Gin and Tonic" ),
    };

}
