package pw.megaviral.recipeproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BreakfastCooking extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast__cooking);

        ViewPager viewpager = (ViewPager) findViewById(R.id.breakfastviewpager);
        viewpager.setAdapter(new MyAdaptor(getSupportFragmentManager()));


    }
    public class MyAdaptor extends FragmentPagerAdapter{

        public MyAdaptor(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
          if(position == 0){
                return new Dish_Description();
           }
          else

            return new BreakfastIngredients();
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position == 0){
                return "Description";
            }
            else

                return "Ingredients()";

        }
    }
}
