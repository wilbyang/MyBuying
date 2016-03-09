package libwy.symbio.com.mybuying.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by wilbyang on 02/03/16.
 */
public class EqualSpaceItemDecoration extends RecyclerView.ItemDecoration {

    private final int space;

    public EqualSpaceItemDecoration(int mSpaceHeight) {
        this.space = mSpaceHeight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {

            outRect.top = space;
            outRect.bottom = space;
        //outRect.left = mSpaceHeight;
        //outRect.right = mSpaceHeight;
    }
}