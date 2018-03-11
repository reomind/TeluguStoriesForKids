package consulting.zolute.telugustoriesforkids.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hussain on 11-Mar-18.
 */

public class ApiClient {
    public static final String BASE_URL = "http://telugustories.zolute.xyz/api/";
    public static final String APPLICATION_URL = "http://telugustories.zolute.xyz/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
