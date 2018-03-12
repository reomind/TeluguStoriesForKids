package consulting.zolute.telugustoriesforkids;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import consulting.zolute.telugustoriesforkids.model.Story;
import consulting.zolute.telugustoriesforkids.model.StoryResponse;
import consulting.zolute.telugustoriesforkids.rest.ApiClient;
import consulting.zolute.telugustoriesforkids.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoryListActivity extends AppCompatActivity {

    private List<Story> stories = new ArrayList<>();
    private RecyclerView recyclerView;
    private StoriesAdapter storyAdapter;
    public String categoryID = getIntent().getStringExtra("CATEGORY_ID");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_list);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        storyAdapter = new StoriesAdapter(stories);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(storyAdapter);
        prepareStoryData();

    }

    private void prepareStoryData() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<StoryResponse> call = apiService.getStories(categoryID);
        call.enqueue(new Callback<StoryResponse>() {
            @Override
            public void onResponse(Call<StoryResponse> call, Response<StoryResponse> response) {
                stories = response.body().getStories();
                Log.d("mLog","total stories found "+ stories.size());
                storyAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<StoryResponse> call, Throwable t) {
                Log.d("mLog",t.toString());
            }
        });
    }
}
