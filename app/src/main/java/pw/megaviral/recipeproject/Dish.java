package pw.megaviral.recipeproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import pw.megaviral.recipeproject.cetorgry.CetorgryBean;
import pw.megaviral.recipeproject.dish.BreakfastAdaptor;
import pw.megaviral.recipeproject.dish.DishBal;
import pw.megaviral.recipeproject.dish.DishBean;

public class Dish extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    DishBal bal;
    ArrayList<DishBean> list = null;
    RecyclerView.LayoutManager  layoutmanager;
    int[] breakfast_image = {R.drawable.fiveminuteveganancakes,R.drawable.applebtes,R.drawable.harvestpumpkinapplebread,
            R.drawable.lowcarbbreakfastballs,R.drawable.minipigsinablanket,R.drawable.pancakes,
            R.drawable.petesscratchpancakes,R.drawable.thebestestbelgianeaffles,R.drawable.thebesteverwaffles,R.drawable.turkeybreakfastsausagepatties};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_break_fast);

        bal = new DishBal(this);

        Bundle extras = getIntent().getExtras();
        String StringVariableName = extras.getString("cetorgry_IDs");
        int IntVariableName=Integer.parseInt(StringVariableName);
        int cid =IntVariableName+1;
        Log.i("key",""+ cid);


        SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isFirstRun = wmbPreference.getBoolean("DishShared", true);
        if (isFirstRun)
        {
            bal.addDish(new DishBean(1, 1, "5 Minute Pancakes", breakfast_image[1], "By Awais", "30 mins"));
            bal.addDish(new DishBean(2, 2, "Apple Bites", breakfast_image[2], "By Ahmed", "6 h"));
            bal.addDish(new DishBean(3, 4, "Harvest Apple Bread", breakfast_image[3], "By Awais", "19 h"));
            bal.addDish(new DishBean(4, 4, "Low Carb Breakfast Balls", breakfast_image[4], "By Danish", "23 h"));
            bal.addDish(new DishBean(5, 1, "Mini Pigs-In-A-Blanket", breakfast_image[5], "By Ali", "2 days"));
            bal.addDish(new DishBean(6, 1, "Pancakes", breakfast_image[6], "By Safdar", "1 week"));
            bal.addDish(new DishBean(7, 2, "Pete's Scratch Pancakes", breakfast_image[7], "By Safdar", "1 week"));
            bal.addDish(new DishBean(8, 5, "The Best Ever Waffles", breakfast_image[8], "By Safdar", "1 week"));
            bal.addDish(new DishBean(9, 5, "The Belgian Waffles", breakfast_image[9], "By Safdar", "1 week"));


            SharedPreferences.Editor editor = wmbPreference.edit();
            editor.putBoolean("DishShared", false);
            editor.commit();

        }

       list = (ArrayList<DishBean>) bal.getAllDishes(cid);

        if(list.size() > 0){


            adapter =new BreakfastAdaptor(cid,list);
            recyclerView = (RecyclerView) findViewById(R.id.breakfast_recycleview);
            layoutmanager = new GridLayoutManager(this,2);
            recyclerView.setLayoutManager(layoutmanager);
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(adapter);
        }else{

            Toast.makeText(this, "No Data Avbl", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,Categories.class ));
        }

    }

}

