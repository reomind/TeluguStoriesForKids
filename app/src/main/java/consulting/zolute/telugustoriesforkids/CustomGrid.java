package consulting.zolute.telugustoriesforkids;

/**
 * Created by hussain on 11-Mar-18.
 */
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.squareup.picasso.Picasso;


import java.util.List;

import consulting.zolute.telugustoriesforkids.extensions.SquareImageView;
import consulting.zolute.telugustoriesforkids.model.Categories;
import consulting.zolute.telugustoriesforkids.rest.ApiClient;


public class CustomGrid extends BaseAdapter {
    private Context mContext;
    private final List<Categories> categories;

    public CustomGrid(Context c, List<Categories> categories){
        mContext = c;
        this.categories = categories;
    }


    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(view == null){
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.single_grid,null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            textView.setText(categories.get(i).getName());
            // get the image from the media
            String url = ApiClient.APPLICATION_URL + "mediamanager/download/" + categories.get(i).getMediaID();
            Log.d("myLog",url);
            SquareImageView imageView = (SquareImageView ) grid.findViewById(R.id.categoryImage);
            Picasso.get().load(url).resize(500,500).centerCrop().into(imageView);

        }else{
            grid = (View) view;
        }
        return grid;
    }


}
