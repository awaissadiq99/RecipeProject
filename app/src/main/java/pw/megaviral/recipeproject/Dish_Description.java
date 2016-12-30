package pw.megaviral.recipeproject;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import pw.megaviral.recipeproject.cetorgry.CetorgryBal;
import pw.megaviral.recipeproject.description.DescriptionBal;
import pw.megaviral.recipeproject.description.DescriptionBean;
import pw.megaviral.recipeproject.dish.DishBal;
import pw.megaviral.recipeproject.dish.DishBean;


/**
 * A simple {@link Fragment} subclass.
 */
public class Dish_Description extends Fragment {


    ImageView imageView;
    TextView description,dishname,dishCetorgry;
    DescriptionBal descbal = null;
    DescriptionBean descriptionBean = null;

    public Dish_Description() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  fregmentview =  inflater.inflate(R.layout.fragment_breakfast__description, container, false);
        imageView = (ImageView) fregmentview.findViewById(R.id.imageViewBreakfastCookingDescriotion);
        description = (TextView) fregmentview.findViewById(R.id.textViewBreakfastCookingDescription);
        dishname = (TextView) fregmentview.findViewById(R.id.textViewbreakfastDishName);
        dishCetorgry= (TextView) fregmentview.findViewById(R.id.textViewbreakfastDishNameCetorgry);

        Bundle extras = getActivity().getIntent().getExtras();
        String StringVariableName = extras.getString("cetorgry_ID");
        String StringVariableNameDish = extras.getString("dish_ID");

        int IntVariableName=Integer.parseInt(StringVariableName);
        int IntVariableNameDish=Integer.parseInt(StringVariableNameDish);

        int cid =IntVariableName;
        int did   = IntVariableNameDish+1;



        descbal= new DescriptionBal(getActivity());

        SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(getActivity());
        boolean isFirstRun = wmbPreference.getBoolean("DescriptionShared", true);
        if (isFirstRun)
        {
            descbal.addDescription(new DescriptionBean(1,1,1,"THIS IS Category 1 And Dish 1 CHAT"));
            descbal.addDescription(new DescriptionBean(2,1,1,"THIS IS Category 1 And Dish 2 CHAT"));
            descbal.addDescription(new DescriptionBean(3,1,1,"THIS IS Category 1 And Dish 3 CHAT"));
            descbal.addDescription(new DescriptionBean(1,2,1,"THIS IS Category 2 And Dish 1 CHAT"));
            descbal.addDescription(new DescriptionBean(2,2,1,"THIS IS Category 2 And Dish 2 CHAT"));
            descbal.addDescription(new DescriptionBean(3,4,1,"THIS IS Category 3 And Dish 1 CHAT"));


            SharedPreferences.Editor editor = wmbPreference.edit();
            editor.putBoolean("DescriptionShared", false);
            editor.commit();
        }

        descriptionBean = descbal.getAllDescription(cid,did);
        DishBal dishBal = new DishBal(getActivity());
        CetorgryBal catebal = new CetorgryBal(getActivity());

        DishBean dishBean = dishBal.getSelectDishe(did);
//        description.setText(descriptionBean.getDescription_detail());
        dishname.setText(dishBean.getDish_name());
        dishCetorgry.setText(catebal.getAllCetory().get(cid).getCetorgry_name());
        imageView.setImageResource(dishBean.getDish_pic());


        return fregmentview;


    }

}
