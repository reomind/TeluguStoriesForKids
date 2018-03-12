package consulting.zolute.telugustoriesforkids.activities;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

import consulting.zolute.telugustoriesforkids.R;
import consulting.zolute.telugustoriesforkids.rest.ApiClient;

public class ImageScrollViewActivity extends AppCompatActivity {

    private String mediaID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_image_scroll_view);

        PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);
        mediaID = getIntent().getExtras().getString("MEDIA_ID");
        String url = ApiClient.APPLICATION_URL + "mediamanager/download/" + mediaID;
        Picasso.get().load(url).into(photoView);

    }
}
