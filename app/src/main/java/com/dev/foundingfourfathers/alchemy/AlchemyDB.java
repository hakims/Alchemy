package com.dev.foundingfourfathers.alchemy;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by alihakimi on 2/27/2015.
 */
public class AlchemyDB extends SQLiteOpenHelper{

    /** Database version - change to upgrade */
    private static final int DB_VERSION = 1;

    /** Name of database - don't change  */
    private static final String DB_NAME = "alchemyDB";

    /** Application context */
    protected Context c = null;

    /** Reference to SQLite database */
    static SQLiteDatabase db = null;

    /**
     * COCKTAIL table: Stores Cocktail information
     */
    private static final String ALCHEMY_TABLE = "AlchemyTable";
    private static final String ALCHEMY_COL_ALCOHOLS = "users_alcohols";     /// Holds what alcohols the user has in their basket
    private static final String ALCHEMY_COL_MIXERS = "users_mixers";         /// Holds what mixers the user has in their basket
    private static final String ALCHEMY_COL_COCKTAILS = "cocktails_list";	  /// Holds all the possible mixed drinks

    /**
     * Default constructor for class.  Passes application context to parent and gets reference to database.
     *
     * @param context: (Context) Application context
     */
    public AlchemyDB(Context context) {

        super (context, DB_NAME, null, DB_VERSION);
        Log.i(getClass().getSimpleName(), "DB Initialized");
        c = context;
        db = this.getWritableDatabase();

    }

    /**
     * Creates the database.  It is only called when there is a new version passed into the helper.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {


        String sql1 = 	"CREATE TABLE " + ALCHEMY_TABLE + "(" +
                ALCHEMY_COL_ALCOHOLS + " DOUBLE NOT NULL, " +
                ALCHEMY_COL_MIXERS + " DOUBLE NOT NULL, " +
                ALCHEMY_COL_COCKTAILS + " DOUBLE NOT NULL " +
                ");";



        try {
            db.beginTransaction();
            db.execSQL(sql1);
            Log.i(getClass().getName(), "Table Created:" + ALCHEMY_TABLE);
            db.setTransactionSuccessful();
            db.endTransaction();


            Log.i(getClass().getName(), "Database Created:" + DB_VERSION);

        } catch (SQLException e) {
            Log.e(getClass().getName(), "Could not create database");
        }



    }


    /**
     * Upgrades the database.
     */


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)  {
        //*****************************************************************************************************************
        //** This method is called when there is a new version of the database being used.
        //*****************************************************************************************************************

        String dropSQL1 = "DROP TABLE IF EXISTS " + ALCHEMY_TABLE + ";";

        try {
            db.beginTransaction();
            db.execSQL(dropSQL1);
            Log.i (getClass().getName(),"Table dropped:" + ALCHEMY_TABLE);

            db.setTransactionSuccessful();
            db.endTransaction();
            onCreate(db);


        } catch (SQLException e) {

            Log.e(getClass().getName(), "Upgrade failed:" + e.getMessage());
        } catch (Exception e) {
            Log.e(getClass().getName(), "Upgrade failed - Uncaught error");
        }



    }
}
