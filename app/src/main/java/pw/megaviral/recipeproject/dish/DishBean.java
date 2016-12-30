package pw.megaviral.recipeproject.dish;

/**
 * Created by awais-pc on 12/14/2016.
 */

public class DishBean {
    private int dish_id;
    private int cat_id;
    private  String dish_name;
    private int dish_pic;
    private String dish_author;
    private String dish_time;

    public DishBean(int dish_id, int cat_id, String dish_name, int dish_pic, String dish_author, String dish_time) {
        this.dish_id = dish_id;
        this.cat_id = cat_id;
        this.dish_name = dish_name;
        this.dish_pic = dish_pic;
        this.dish_author = dish_author;
        this.dish_time = dish_time;
    }

    public int getDish_id() {
        return dish_id;
    }

    public void setDish_id(int dish_id) {
        this.dish_id = dish_id;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public int getDish_pic() {
        return dish_pic;
    }

    public void setDish_pic(int dish_pic) {
        this.dish_pic = dish_pic;
    }

    public String getDish_author() {
        return dish_author;
    }

    public void setDish_author(String dish_author) {
        this.dish_author = dish_author;
    }

    public String getDish_time() {
        return dish_time;
    }

    public void setDish_time(String dish_time) {
        this.dish_time = dish_time;
    }
}
