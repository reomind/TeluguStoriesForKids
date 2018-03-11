package consulting.zolute.telugustoriesforkids.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hussain on 11-Mar-18.
 */

public class CategoriesResponse {
    @SerializedName("categories")
    private List<Categories> categories;

    public List<Categories> getCategories(){
        return categories;
    }

    public void setCategories(List<Categories> categories){
        this.categories = categories;
    }

}
