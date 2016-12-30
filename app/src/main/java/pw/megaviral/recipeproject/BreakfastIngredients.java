package pw.megaviral.recipeproject;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BreakfastIngredients extends Fragment {
    ArrayList<String> arrayList = new ArrayList<String>();
    ListView listView;
    public BreakfastIngredients() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View fregmentview = inflater.inflate(R.layout.fragment_cooking_ingredients, container, false);
        listView = (ListView) fregmentview.findViewById(R.id.listview_breakfast_ingredients);
        Intent i = getActivity().getIntent();
        String breakfast_name = i.getStringExtra("Breakfast_Name");
        String dish_Cetorgry = i.getStringExtra("Cetorgrye");
        int  breakfast_id = i.getIntExtra("Breakfast_Id",0);

        arrayList.add("1 cup white sugar");
        arrayList.add("1/2 cup butter");
        arrayList.add("2 eggs");
        arrayList.add("2 teaspoons vanilla extract");
        arrayList.add("1 1/2 cups all-purpose flour");
        arrayList.add("1 3/4 teaspoons baking powder");
        arrayList.add("1/2 cup milk");
        String[] abc = fregmentview.getContext().getResources().getStringArray(R.array.ingredition);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(fregmentview.getContext(), android.R.layout.simple_list_item_1,abc);

        listView.setAdapter(adapter);
        return fregmentview;

    }

}
