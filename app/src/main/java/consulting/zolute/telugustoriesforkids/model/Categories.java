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

    @SerializedName("mediaID")
    private String mediaID;

    public Categories(String ID, String name, String mediaID){
        this.ID = ID;
        this.name = name;
        this.mediaID = mediaID;
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

    public String getMediaID(){
        return mediaID;
    }

    public void setMediaID(String mediaID){
        this.mediaID = mediaID;
    }

}
