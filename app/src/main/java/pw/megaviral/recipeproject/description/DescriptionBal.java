package pw.megaviral.recipeproject.description;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import pw.megaviral.recipeproject.dbconnect.DBConnect;
import pw.megaviral.recipeproject.dish.DishBean;

/**
 * Created by awais-pc on 12/26/2016.
 */

public class DescriptionBal {
    private DBConnect dbConnect;

    public DescriptionBal(Context c) {
        dbConnect = new DBConnect(c);
    }


    public long addDescription(DescriptionBean bean){

        SQLiteDatabase sdb = dbConnect.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("category_ID",bean.getCategory_id());
        values.put("dish_ID",bean.getDish_id());
        values.put("desc_detail",bean.getDescription_detail());

        long id =sdb.insert("description",null,values);
        sdb.close();
        return id;

    }


    public DescriptionBean getAllDescription(int cate_id,int dis_id){
        SQLiteDatabase sdb = dbConnect.getWritableDatabase();
        String query = "Select * from description where category_ID=? AND dish_ID=?";
        DescriptionBean bean = null;
        Cursor cursor = sdb.rawQuery(query, new String[] {cate_id+"",dis_id+""});

        if (cursor.moveToNext()){
            int desc_id = cursor.getInt(0);
            int category_ID = cursor.getInt(1);
            int dish_ID = cursor.getInt(2);
            String desc_detail = cursor.getString(3);


               new DescriptionBean(desc_id,category_ID,dish_ID,desc_detail);

        }//end loop
        sdb.close();
        return bean;
    }//end getAllCetory



    public void addMyDescription(List<DescriptionBean> list,int cate_id,int dis_id){
        SQLiteDatabase sdb =  dbConnect.getWritableDatabase();

        Cursor cur = sdb.rawQuery("Select * from description where category_ID=? AND dish_ID=?", new String[] {cate_id+"",dis_id+""});

        if (cur != null) {
            cur.moveToFirst();                       // Always one row returned.
            // cur.getCount()<0
            if (cur.getInt (0) == 0) {               // Zero count means empty table.
                ContentValues contentValues  = new ContentValues();
                for (int i = 0 ; i<list.size(); i++){
                    DescriptionBean bean = list.get(i);

                    contentValues.put("category_ID",bean.getCategory_id());
                    contentValues.put("dish_ID",bean.getDish_id());
                    contentValues.put("desc_detail",bean.getDescription_detail());

                    //Log.e("test Data ",""+bean.getProPrice());

                    Log.e("Loop",""+""+i);
                    sdb.insert("description",null,contentValues);
                }


                sdb.close();
                Log.e("Data Insert","Sucessfull");
            }
            else {
                Log.e("Data Error","Data Already Insert"+list.size());
            }
        }

    }// end addMyDishes
}
