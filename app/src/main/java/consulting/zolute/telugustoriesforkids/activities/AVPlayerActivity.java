package consulting.zolute.telugustoriesforkids.activities;



import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;


import consulting.zolute.telugustoriesforkids.R;
import consulting.zolute.telugustoriesforkids.rest.ApiClient;

public class AVPlayerActivity extends AppCompatActivity {
    private String mediaID;
    private String storyName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avplayer);
        storyName = getIntent().getExtras().getString("STORY_NAME");
        setTitle(storyName);

        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        TrackSelection.Factory videoTrackSelectionFactory =
                new AdaptiveTrackSelection.Factory(bandwidthMeter);
        TrackSelector trackSelector =
                new DefaultTrackSelector(videoTrackSelectionFactory);

// 2. Create the player
        SimpleExoPlayer player =
                ExoPlayerFactory.newSimpleInstance(getBaseContext(), trackSelector);
        PlayerView playerView = (PlayerView) findViewById(R.id.video_view);
        playerView.setPlayer(player);

// This is the MediaSource representing the media to be played.
        mediaID = getIntent().getExtras().getString("MEDIA_ID");
        String url = ApiClient.APPLICATION_URL + "mediamanager/download/" + mediaID;
        MediaSource videoSource = new ExtractorMediaSource.Factory(new DefaultHttpDataSourceFactory("exoplayer-codelab"))
                .createMediaSource(Uri.parse(url));
        player.prepare(videoSource);

    }

}
