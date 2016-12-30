package pw.megaviral.recipeproject.dish;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import pw.megaviral.recipeproject.BreakfastCooking;
import pw.megaviral.recipeproject.R;

/**
 * Created by awais-pc on 12/14/2016.
 */

public class BreakfastAdaptor extends RecyclerView.Adapter<BreakfastAdaptor.BreakfastViewHolder> {
    private int cid;
    private int did;
    public BreakfastAdaptor(int cid, ArrayList<DishBean> arrayList) {
        this.cid = cid;
        this.arrayList = arrayList;
    }
    ArrayList<DishBean> arrayList = new ArrayList<>();
    @Override
    public BreakfastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.breakfast_custom_layout,parent,false);
        BreakfastViewHolder breakfastViewHolder = new BreakfastViewHolder(view);
        return breakfastViewHolder;
    }

    @Override
    public void onBindViewHolder(BreakfastViewHolder holder, final int position) {
        final DishBean bean = arrayList.get(position);
        did = position;
        holder.breakfast_img.setImageResource(bean.getDish_pic());
        holder.breakfast_name.setText(bean.getDish_name());
        holder.breakfast_author.setText(bean.getDish_author());
        holder.breakfast_time.setText(bean.getDish_time());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DishBean bean = arrayList.get(position);

                Intent i = new Intent(v.getContext(), BreakfastCooking.class);
                Bundle extras = new Bundle();
                extras.putString("cetorgry_ID", ""+cid);
                extras.putString("dish_ID", ""+did);

                i.putExtras(extras);
                v.getContext().startActivity(i);
                Toast.makeText(v.getContext(), "Check id"+position, Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {

        return arrayList.size();

    }

    public static class BreakfastViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView breakfast_img;
        TextView breakfast_name;
        TextView breakfast_author;
        TextView breakfast_fav;
        TextView breakfast_time;
        CardView cardView;

        public BreakfastViewHolder(View itemView) {
            super(itemView);
            breakfast_img = (ImageView) itemView.findViewById(R.id.breakfastimageView);
            breakfast_name = (TextView) itemView.findViewById(R.id.breakfastDishName);
            breakfast_author = (TextView) itemView.findViewById(R.id.breakfastDishAuthor);
            breakfast_fav = (TextView) itemView.findViewById(R.id.breakfastfavtextview);
            breakfast_time = (TextView) itemView.findViewById(R.id.breakfastTimetextview);
            cardView = (CardView) itemView.findViewById(R.id.cardviewbreakfast);
        }
        @Override
        public void onClick(View v) {
           int position = getAdapterPosition();
            Toast.makeText(v.getContext(), "TOAst", Toast.LENGTH_SHORT).show();
        }
    }
}
