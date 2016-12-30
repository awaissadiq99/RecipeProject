package pw.megaviral.recipeproject.dish;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import pw.megaviral.recipeproject.cetorgry.CetorgryBean;
import pw.megaviral.recipeproject.dbconnect.DBConnect;

/**
 * Created by awais-pc on 12/22/2016.
 */

public class DishBal {
    private DBConnect dbConnect;

    public DishBal(Context c) {
        dbConnect = new DBConnect(c);
    }


    public long addDish(DishBean bean){
        SQLiteDatabase sdb = dbConnect.getWritableDatabase();
        ContentValues values = new ContentValues();
            values.put("category_ID",bean.getCat_id());
            values.put("dish_Name",bean.getDish_name());
            values.put("dish_Pic",bean.getDish_pic());
            values.put("dish_Author",bean.getDish_author());
            values.put("dish_Time",bean.getDish_time());
        long id =sdb.insert("dish",null,values);
        sdb.close();
        return id;

    }// end Add addDish

    public List<DishBean> getAllDishes(int id){
        SQLiteDatabase sdb = dbConnect.getWritableDatabase();
        String query = "Select * from dish where category_ID="+id;
        List<DishBean> list = new ArrayList<>();
        Cursor cursor = sdb.rawQuery(query, null);

        while (cursor.moveToNext()){
            int dish_id = cursor.getInt(0);
            int cat_id = cursor.getInt(1);
            String dish_name = cursor.getString(2);
            int dish_pic = cursor.getInt(3);
            String dish_author = cursor.getString(4);
            String dish_time = cursor.getString(5);

            list.add(new DishBean(dish_id, cat_id,dish_name,dish_pic,dish_author,dish_time));

        }//end loop
        sdb.close();
        return list;
    }//end getAllDishes

    public DishBean getSelectDishe(int id){
        SQLiteDatabase sdb = dbConnect.getWritableDatabase();
        String query = "Select * from dish where dish_ID= ?";

        Cursor cursor = sdb.rawQuery(query, new String[] {id+""});
        DishBean bean=null;
        while (cursor.moveToNext()){
            int dish_id = cursor.getInt(0);
            int cat_id = cursor.getInt(1);
            String dish_name = cursor.getString(2);
            int dish_pic = cursor.getInt(3);
            String dish_author = cursor.getString(4);
            String dish_time = cursor.getString(5);

             bean = new DishBean(dish_id, cat_id,dish_name,dish_pic,dish_author,dish_time);

        }//end loop
        sdb.close();

        return bean;
    }//end getSelectDishe


}
