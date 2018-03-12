package consulting.zolute.telugustoriesforkids.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import consulting.zolute.telugustoriesforkids.R;

public class TextViewStoryActivity extends AppCompatActivity {

    private String storyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view_story);
        storyText = getIntent().getExtras().getString("STORY_TEXT");
        TextView textView = (TextView) findViewById(R.id.story_text);
        textView.setText(storyText);
    }
}
