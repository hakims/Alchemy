package com.dev.foundingfourfathers.alchemy.DrinkStrategies;

/**
 * Created by alihakimi on 4/25/2015.
 */
public interface Observer {

    public void updateAfterAdd(String basketItem);
    public void updateAfterRemove(String basketItem);

}
