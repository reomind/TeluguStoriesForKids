package consulting.zolute.telugustoriesforkids.rest;

import consulting.zolute.telugustoriesforkids.model.CategoriesResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hussain on 11-Mar-18.
 */

public interface ApiInterface {

    @GET("categories")
    Call<CategoriesResponse> getCategories();


}
