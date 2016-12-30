package pw.megaviral.recipeproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.parse.Parse;
import com.parse.ParseObject;

import java.util.List;

import pw.megaviral.recipeproject.cetorgry.CetorgryBal;
import pw.megaviral.recipeproject.cetorgry.CetorgryBaseAdaptor;
import pw.megaviral.recipeproject.cetorgry.CetorgryBean;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Categories extends AppCompatActivity {
    //ArrayList<CetorgryBean> arrayList;
    CetorgryBal bal;
    ListView listView;
    List<CetorgryBean> list=null;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        listView = (ListView) findViewById(R.id.listviewCetorgry);

        bal = new CetorgryBal(this);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("wlVC0FvMW120X8YyMjkaiBISiCYWoYhx7R4RSoXo")
                .clientKey("zKIb86QNlZg804ScBkz0NBbdK4h7ItLxAZrDR9IB")
                .server("https://parseapi.back4app.com/").build()
        );

        ParseObject parseObject = new ParseObject("Recipe");

       int parseid = parseObject.getInt("category_id");
        String parsename = parseObject.getString("Categoryname");
        String parseImage = parseObject.getString("cat_image");

        Log.i("Parse","Parse Id :"+parseid);
        Log.i("Parse","Parse Name :"+parsename);
        Log.i("Parse","Parse Image :"+parseImage);

        parseObject.put("category_id",2);
        parseObject.put("Categoryname","NEW ITEM");
        parseObject.put("cat_image","NEW Image");
        parseObject.saveInBackground();



        SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);
        if (isFirstRun)
        {
           bal.addCetorgry(new CetorgryBean(0,"BREAKFAST",R.drawable.breakfast));
            bal.addCetorgry(new CetorgryBean(0,"COFFEE",R.drawable.coffee));
            bal.addCetorgry(new CetorgryBean(0,"APPETIZERS",R.drawable.appetizers));
            bal.addCetorgry(new CetorgryBean(0,"LUNCH",R.drawable.lunch));
            bal.addCetorgry(new CetorgryBean(0,"DRINK",R.drawable.drink));


            SharedPreferences.Editor editor = wmbPreference.edit();
            editor.putBoolean("FIRSTRUN", false);
            editor.commit();
        }

        list = bal.getAllCetory();
        listView.setAdapter(new CetorgryBaseAdaptor(list,this));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    id = position;

                Intent i = new Intent(Categories.this ,Dish.class);


                Bundle extras = new Bundle();
                extras.putString("cetorgry_IDs", ""+id);
                i.putExtras(extras);
                startActivity(i);

            }
        });
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
