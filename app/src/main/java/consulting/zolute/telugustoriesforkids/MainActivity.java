package consulting.zolute.telugustoriesforkids;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
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
    private  List<Categories> categories = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("testing");
        grid = (GridView)findViewById(R.id.gridview);
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<CategoriesResponse> call = apiService.getCategories();
        call.enqueue(new Callback<CategoriesResponse>() {
            @Override
            public void onResponse(Call<CategoriesResponse> call, Response<CategoriesResponse> response) {
                categories = response.body().getCategories();
                Log.d("myLog","Number of categroies received"+categories.size());
                //CustomGrid adapter = new CustomGrid(MainActivity.this,categories);

                grid.setAdapter(new CustomGrid(getApplicationContext(),categories));

            }

            @Override
            public void onFailure(Call<CategoriesResponse> call, Throwable t) {
                Log.d("myLog",t.toString());

            }
        });

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("nLog",String.valueOf(i));
                String categoryID = categories.get(i).getID();
                Intent intent = new Intent(getBaseContext(),StoryListActivity.class);
                intent.putExtra("CATEGORY_ID",categoryID);
                startActivity(intent);

            }
        });


    }

}
