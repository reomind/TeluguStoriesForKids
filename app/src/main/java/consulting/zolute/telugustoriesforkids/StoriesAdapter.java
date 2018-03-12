package consulting.zolute.telugustoriesforkids;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import consulting.zolute.telugustoriesforkids.model.Story;

/**
 * Created by hussain on 11-Mar-18.
 */


public class StoriesAdapter extends RecyclerView.Adapter<StoriesAdapter.MyViewHolder> {

    private List<Story> stories;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView storyName;
        public MyViewHolder(View view) {
            super(view);
            storyName = (TextView) view.findViewById(R.id.storyName);

        }
    }

    public StoriesAdapter(List<Story> stories){
        this.stories = stories;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_list_row,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Story story = stories.get(position);
        holder.storyName.setText(story.getTitle());
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }
}
