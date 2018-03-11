package consulting.zolute.telugustoriesforkids.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hussain on 11-Mar-18.
 */

public class Categories {

    @SerializedName("id")
    private String ID;

    @SerializedName("name")
    private String name;

    public Categories(String ID, String name){
        this.ID = ID;
        this.name = name;
    }

    public String getID(){
        return ID;
    }

    public void setID(String ID){
        this.ID = ID;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
