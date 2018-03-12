package consulting.zolute.telugustoriesforkids.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hussain on 11-Mar-18.
 */

public class Story {
    @SerializedName("id")
    private String ID;

    @SerializedName("title")
    private String title;

    @SerializedName("type")
    private String storyType;

    @SerializedName("description")
    private String description;

    @SerializedName("storyText")
    private String storyText;

    @SerializedName("mediaID")
    private String mediaID;

    public Story(){

    }

    public String getID(){
        return ID;
    }

    public String getTitle(){
        return title;
    }

    public String getStoryType(){
        return storyType;
    }

    public String getDescription(){
        return description;
    }

    public String getStoryText(){
        return storyText;
    }

    public String getMediaID(){
        return mediaID;
    }

    public void setID(String ID){
        this.ID = ID;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setStoryType(String storyType){
        this.storyType = storyType;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setStoryText(String storyText){
        this.storyText = storyText;
    }

    public void setMediaID(String mediaID){
        this.mediaID = mediaID;
    }
}
