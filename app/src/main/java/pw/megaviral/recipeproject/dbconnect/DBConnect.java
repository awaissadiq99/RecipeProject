package pw.megaviral.recipeproject.dbconnect;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by awais-pc on 12/20/2016.
 */

public class DBConnect extends SQLiteOpenHelper
{
    public DBConnect(Context context) {
        super(context, "RecipeProject", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE  TABLE  IF NOT EXISTS cetegory (category_ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, cetegory_Name TEXT NOT NULL,cetegory_Picture TEXT NOT NULL);";
        db.execSQL(query);
        String query2 ="CREATE  TABLE  IF NOT EXISTS dish (dish_ID	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,category_ID INTEGER, dish_Name	TEXT, dish_Pic TEXT, dish_Author TEXT, dish_Time TEXT,FOREIGN KEY(category_ID) REFERENCES cetegory(category_ID));";
        db.execSQL(query2);
        String query3 = "CREATE  TABLE  IF NOT EXISTS description (desc_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,category_ID INTEGER,dish_ID INTEGER,desc_detail TEXT,FOREIGN KEY(category_ID) REFERENCES cetegory(category_ID), FOREIGN KEY(dish_ID) REFERENCES dish(dish_ID));";
        db.execSQL(query3);
    }//end onCreate
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }//end onUpgrade
}
