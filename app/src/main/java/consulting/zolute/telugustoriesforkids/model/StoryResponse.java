package consulting.zolute.telugustoriesforkids.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hussain on 11-Mar-18.
 */

public class StoryResponse {
    @SerializedName("stories")
    private List<Story> stories;

    public void setStories(List<Story> stories){
        this.stories = stories;
    }

    public List<Story> getStories(){
        return stories;
    }
}
