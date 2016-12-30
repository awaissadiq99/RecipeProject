package pw.megaviral.recipeproject.cetorgry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pw.megaviral.recipeproject.R;

/**
 * Created by awais-pc on 12/12/2016.
 */

public class CetorgryBaseAdaptor extends BaseAdapter {
    List<CetorgryBean> list;
    Context c;

    public CetorgryBaseAdaptor(List<CetorgryBean> list, Context c) {
        this.list = list;
        this.c = c;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater vi = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View myView = vi.inflate(R.layout.custom_categories,null);

        View myViewlinear = vi.inflate(R.layout.custom_categories,null);

        ImageView photo =(ImageView) myView.findViewById(R.id.imagecetorgry);
        TextView name = (TextView) myView.findViewById(R.id.textcetorgry);


        CetorgryBean obj = list.get(position);

        name.setText(obj.getCetorgry_name());
        photo.setImageResource(obj.getCetorgry_image());

        return  myView;

    }
}
