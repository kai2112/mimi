package fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import activity.DetailActivity;

/**
 * Created by kai on 2016/07/15.
 */
public class BaseFragment extends Fragment {
    public static final int THUMBNAIL_2_LINE_ROW = 2;
    public static final int THUMBNAIL_3_LINE_ROW = 3;

    /**
     * サムネイルエリアにサムネイルを並べる
     * @param thumbnailArea
     * @param sampleThumbnailList
     */
    public void makeThumbnailAreaLayout(LinearLayout thumbnailArea, ArrayList<ImageView> sampleThumbnailList, int row) {
        for (int i = 0; i < sampleThumbnailList.size(); i++) {
            LinearLayout thumbnailLayout;

            if (row == THUMBNAIL_2_LINE_ROW) {
                thumbnailLayout = makeThumbnail2LineRow(thumbnailArea);
            } else if (row == THUMBNAIL_3_LINE_ROW) {
                // TODO...
                thumbnailLayout = new LinearLayout(getContext());
            } else {
                // TODO...
                thumbnailLayout = new LinearLayout(getContext());
            }

            thumbnailLayout.addView(sampleThumbnailList.get(i));

            i++;

            if (i < sampleThumbnailList.size()) {
                thumbnailLayout.addView(sampleThumbnailList.get(i));
            }

            thumbnailArea.addView(thumbnailLayout);
        }
    }

        public LinearLayout makeThumbnail2LineRow(View thumbnailArea) {
        LinearLayout thumbnailAreaLayout = new LinearLayout(getContext());
        ViewGroup.LayoutParams thumbnailLayoutParams = new ViewGroup.LayoutParams(thumbnailArea.getWidth(), (thumbnailArea.getWidth() / 2));
        thumbnailAreaLayout.setLayoutParams(thumbnailLayoutParams);
        thumbnailAreaLayout.setOrientation(LinearLayout.HORIZONTAL);

        return thumbnailAreaLayout;
    }




    public View.OnClickListener thumbnailClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            android.util.Log.d("kai", "view = "+view.getTag());

            Intent intent = new Intent(getContext(), DetailActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    };
}
