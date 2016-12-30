package pw.megaviral.recipeproject.cetorgry;

import android.graphics.drawable.Drawable;

/**
 * Created by awais-pc on 12/12/2016.
 */

public class CetorgryBean {
    private int cetorgry_Id;
    private String cetorgry_name;
    private int cetorgry_image;

    public CetorgryBean(int cetorgry_Id, String cetorgry_name, int cetorgry_image) {
        this.cetorgry_Id = cetorgry_Id;
        this.cetorgry_name = cetorgry_name;
        this.cetorgry_image = cetorgry_image;
    }

    public int getCetorgry_Id() {
        return cetorgry_Id;
    }

    public void setCetorgry_Id(int cetorgry_Id) {
        this.cetorgry_Id = cetorgry_Id;
    }

    public String getCetorgry_name() {
        return cetorgry_name;
    }

    public void setCetorgry_name(String cetorgry_name) {
        this.cetorgry_name = cetorgry_name;
    }

    public int getCetorgry_image() {
        return cetorgry_image;
    }

    public void setCetorgry_image(int cetorgry_image) {
        this.cetorgry_image = cetorgry_image;
    }
}
