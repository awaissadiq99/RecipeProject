package pw.megaviral.recipeproject.description;

/**
 * Created by awais-pc on 12/26/2016.
 */

public class DescriptionBean {
    private int desc_id;
    private int category_id;
    private int dish_id;
    private String description_detail;

    public DescriptionBean(int desc_id, int category_id, int dish_id, String description_detail) {
        this.desc_id = desc_id;
        this.category_id = category_id;
        this.dish_id = dish_id;
        this.description_detail = description_detail;
    }

    public int getDesc_id() {
        return desc_id;
    }

    public void setDesc_id(int desc_id) {
        this.desc_id = desc_id;
    }

    public int getDish_id() {
        return dish_id;
    }

    public void setDish_id(int dish_id) {
        this.dish_id = dish_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getDescription_detail() {
        return description_detail;
    }

    public void setDescription_detail(String description_detail) {
        this.description_detail = description_detail;
    }
}
