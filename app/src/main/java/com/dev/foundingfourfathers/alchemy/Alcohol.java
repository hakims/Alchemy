package com.dev.foundingfourfathers.alchemy;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by alihakimi on 3/30/15.
 */
public class Alcohol extends RealmObject{

   @PrimaryKey
    private String type;

    public Alcohol() { this.type = null; }
    public Alcohol(String type)
    {
        this.type = type;
    }

    public String getType() { return type;}
    public void setType(String t) { type = t;}

}

//class Vodka extends Alcohol{
//
//    public Vodka()
//    {
//        super();
//        super.setType("Vodka");
//    }
//
//}
//
//class Whiskey extends Alcohol{
//
//    public Whiskey()
//    {
//        super();
//        super.setType("Whiskey");
//    }
//}
