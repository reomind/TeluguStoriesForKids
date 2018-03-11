package consulting.zolute.telugustoriesforkids.extensions;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by hussain on 11-Mar-18.
 */

public class SquareImageView extends ImageView {
    public SquareImageView(Context context) {
        super(context);
    }

    //________auto created constructor
    public SquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //________auto created constructor
    public SquareImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //_______________pass same paramere value for width and geight for the SquareImageView.
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
