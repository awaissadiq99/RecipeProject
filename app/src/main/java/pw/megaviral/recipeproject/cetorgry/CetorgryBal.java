package pw.megaviral.recipeproject.cetorgry;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import pw.megaviral.recipeproject.dbconnect.DBConnect;

/**
 * Created by awais-pc on 12/20/2016.
 */

public class CetorgryBal {
    private DBConnect dbConnect;

    public CetorgryBal(Context c) {
        dbConnect = new DBConnect(c);
    }
    public long addCetorgry(CetorgryBean bean){
        SQLiteDatabase sdb = dbConnect.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("cetegory_Name",bean.getCetorgry_name());
        values.put("cetegory_Picture",bean.getCetorgry_image());
        long id =sdb.insert("cetegory",null,values);

        return id;

    }// end Add Cetorgry

    public void deleteCetegory(int id){
        SQLiteDatabase sdb = dbConnect.getWritableDatabase();
        String arr[] ={String.valueOf(id)};
        sdb.delete("cetegory","category_ID=?",arr);
        sdb.close();
    }// end Delete Cetorgry



    public List<CetorgryBean> getAllCetory(){
        SQLiteDatabase sdb = dbConnect.getWritableDatabase();
        String query = "Select * from cetegory";
        List<CetorgryBean> list = new ArrayList<>();
        Cursor cursor = sdb.rawQuery(query, null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String cat_name = cursor.getString(1);
            int cat_image = cursor.getInt(2);
            list.add(new CetorgryBean(id, cat_name, cat_image));
        }//end loop
        sdb.close();
        return list;
    }//end getAllCetory

    public void addMyCategory(List<CetorgryBean> list){
        SQLiteDatabase sdb =  dbConnect.getWritableDatabase();

        Cursor cur = sdb.rawQuery("SELECT COUNT(*) FROM cetegory", null);
        if (cur != null) {
            cur.moveToFirst();                       // Always one row returned.
            // cur.getCount()<0
            if (cur.getInt (0) == 0) {               // Zero count means empty table.
                ContentValues contentValues  = new ContentValues();
                for (int i = 0 ; i<list.size(); i++){
                    CetorgryBean bean = list.get(i);

                    contentValues.put("cetegory_Name",bean.getCetorgry_name());
                    contentValues.put("cetegory_Picture",bean.getCetorgry_image());
                    //Log.e("test Data ",""+bean.getProPrice());

                    Log.e("Loop",""+""+i);

                    sdb.insert("cetegory",null,contentValues);
                }


                sdb.close();
                Log.e("Data Insert","Sucessfull");
            }
            else {
                Log.e("Data Error","Data Already Insert"+list.size());
            }
        }

    }// end AddMyProducts
}
