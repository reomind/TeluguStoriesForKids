package consulting.zolute.telugustoriesforkids;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import consulting.zolute.telugustoriesforkids.activities.AVPlayerActivity;
import consulting.zolute.telugustoriesforkids.activities.ImageScrollViewActivity;
import consulting.zolute.telugustoriesforkids.activities.TextViewStoryActivity;
import consulting.zolute.telugustoriesforkids.interfaces.RecyclerViewClickListener;
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
    private RecyclerViewClickListener listener;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_list);
        setTitle("కథనాన్ని ఎంచుకోండి");
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        listener = new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                String storyType = stories.get(position).getStoryType();
                switch(storyType){
                    case "1":
                        //text
                        intent = new Intent(getBaseContext(), TextViewStoryActivity.class);
                        intent.putExtra("STORY_TEXT",stories.get(position).getStoryText());
                        intent.putExtra("STORY_NAME",stories.get(position).getTitle());
                        startActivity(intent);
                        break;
                    case "2":
                        //image
                        intent = new Intent(getBaseContext(), ImageScrollViewActivity.class);
                        intent.putExtra("MEDIA_ID",stories.get(position).getMediaID());
                        intent.putExtra("STORY_NAME",stories.get(position).getTitle());
                        startActivity(intent);
                        break;
                    case "3":
                        //video
                        intent = new Intent(getBaseContext(), AVPlayerActivity.class);
                        intent.putExtra("MEDIA_ID",stories.get(position).getMediaID());
                        intent.putExtra("STORY_NAME",stories.get(position).getTitle());
                        startActivity(intent);
                        break;
                    case "4":
                        //audio
                        intent = new Intent(getBaseContext(), AVPlayerActivity.class);
                        intent.putExtra("MEDIA_ID",stories.get(position).getMediaID());
                        intent.putExtra("STORY_NAME",stories.get(position).getTitle());
                        startActivity(intent);
                        break;
                        default:
                            Toast.makeText(getBaseContext(),"Nothing to do",Toast.LENGTH_SHORT).show();
                            break;

                }
                //start new activity


            }
        };
        prepareStoryData();


    }

    private void prepareStoryData() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        String categoryID = getIntent().getExtras().getString("CATEGORY_ID");
        Call<StoryResponse> call = apiService.getStories(categoryID);
        call.enqueue(new Callback<StoryResponse>() {
            @Override
            public void onResponse(Call<StoryResponse> call, Response<StoryResponse> response) {
                stories = response.body().getStories();
                Log.d("mLog","total stories found "+ stories.size());
                storyAdapter = new StoriesAdapter(stories,listener);
                recyclerView.setAdapter(storyAdapter);
            }

            @Override
            public void onFailure(Call<StoryResponse> call, Throwable t) {
                Log.d("mLog",t.toString());
            }
        });

    }
}
