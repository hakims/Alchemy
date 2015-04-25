package com.dev.foundingfourfathers.alchemy.DrinkStrategies;

import android.util.Log;

/**
 * Created by alihakimi on 4/24/2015.
 */
public class DrinkStrategyFactory {

    private DrinkStrategy myStrategy;

    public DrinkStrategyFactory(String type)
    {
        Log.i("INTENT_TEST", "Type: " + type);

        switch(type)
        {
            case "hard":
                Log.i("INTENT_TEST", "I am: " + type);
                myStrategy = new HardAlcoholStrategy();
                break;
            case "light":
                myStrategy = new LightAlcoholStrategy();
                break;
            case "mixer":
                myStrategy = new MixerStrategy();
                break;
            case "liqueur":
                myStrategy = new LiqueurStrategy();
                break;
           // default:
               // myStrategy = new MixerStrategy();
               // break;

        }

    }

    public DrinkStrategy getStrategy()
    {
        return myStrategy;
    }

}
