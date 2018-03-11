package consulting.zolute.telugustoriesforkids;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import java.util.List;

import consulting.zolute.telugustoriesforkids.model.Categories;
import consulting.zolute.telugustoriesforkids.model.CategoriesResponse;
import consulting.zolute.telugustoriesforkids.rest.ApiClient;
import consulting.zolute.telugustoriesforkids.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    GridView grid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid = (GridView)findViewById(R.id.gridview);
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<CategoriesResponse> call = apiService.getCategories();
        call.enqueue(new Callback<CategoriesResponse>() {
            @Override
            public void onResponse(Call<CategoriesResponse> call, Response<CategoriesResponse> response) {
                List<Categories> categories = response.body().getCategories();
                Log.d("myLog","Number of categroies received"+categories.size());
                //CustomGrid adapter = new CustomGrid(MainActivity.this,categories);

                grid.setAdapter(new CustomGrid(getApplicationContext(),categories));
            }

            @Override
            public void onFailure(Call<CategoriesResponse> call, Throwable t) {
                Log.d("myLog",t.toString());

            }
        });


    }

}
