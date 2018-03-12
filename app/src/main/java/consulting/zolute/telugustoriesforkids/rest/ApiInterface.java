package consulting.zolute.telugustoriesforkids.rest;

import consulting.zolute.telugustoriesforkids.model.CategoriesResponse;
import consulting.zolute.telugustoriesforkids.model.StoryResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hussain on 11-Mar-18.
 */

public interface ApiInterface {

    @GET("categories")
    Call<CategoriesResponse> getCategories();

    @GET("stories")
    Call<StoryResponse> getStories(@Query("categoryID") String categoryID);


}
