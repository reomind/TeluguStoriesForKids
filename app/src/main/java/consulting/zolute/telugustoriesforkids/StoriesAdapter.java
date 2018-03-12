package consulting.zolute.telugustoriesforkids;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import consulting.zolute.telugustoriesforkids.interfaces.RecyclerViewClickListener;
import consulting.zolute.telugustoriesforkids.model.Story;

/**
 * Created by hussain on 11-Mar-18.
 */


public class StoriesAdapter extends RecyclerView.Adapter<StoriesAdapter.MyViewHolder> {

    private List<Story> stories;
    private RecyclerViewClickListener mListener;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView storyName;
        private RecyclerViewClickListener mListener;

        public MyViewHolder(View view, RecyclerViewClickListener listener) {
            super(view);
            storyName = (TextView) view.findViewById(R.id.storyName);
            mListener = listener;
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            mListener.onClick(v,getAdapterPosition());
        }
    }

    public StoriesAdapter(List<Story> stories, RecyclerViewClickListener listener){
        this.stories = stories;
        mListener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_list_row,parent,false);
        return new MyViewHolder(itemView, mListener);
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
