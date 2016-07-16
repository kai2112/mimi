package fragment;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.candle.mimi.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by kai on 2016/07/11.
 */
public class CategoryFragment extends BaseFragment {
    private View rootView;

    private LinearLayout categoryThumbnailArea;

    public static CategoryFragment newInstance() {
        return new CategoryFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.category_fragment, container, false);

        categoryThumbnailArea = (LinearLayout)rootView.findViewById(R.id.cotegory_thumbnail_area);
        AssetManager assetManager = getContext().getAssets();

//        pickupVideo = (VideoView)rootView.findViewById(R.id.pickup_video);
//        pickupVideo.setVideoPath("file:///assets/kai_sample.mp4");

        new Handler().post(new Runnable() {
            @Override
            public void run() {

                try {
                    AssetManager assetManager = getContext().getResources().getAssets();
                    InputStream inputStream = assetManager.open("sample_thumbnail.png");
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);


                    int thumbnailSize = categoryThumbnailArea.getWidth() / 2;
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(thumbnailSize, thumbnailSize);
                    android.util.Log.d("kai", "layoutParams = "+layoutParams);

                    // TODO:make sample data...
                    ArrayList<ImageView> sampleThumbnailList = new ArrayList<ImageView>();

                    for (int i = 0; i < 5; i++) {
                        ImageView sampleThumbnail = new ImageView(getContext());
                        sampleThumbnail.setLayoutParams(layoutParams);
                        sampleThumbnail.setImageBitmap(bitmap);
                        sampleThumbnail.setTag("Image"+i);
                        sampleThumbnail.setOnClickListener(thumbnailClickListener);

                        sampleThumbnailList.add(sampleThumbnail);
                    }
                    // TODO:make sample data...

                    makeThumbnailAreaLayout(categoryThumbnailArea, sampleThumbnailList, BaseFragment.THUMBNAIL_2_LINE_ROW);
                } catch (IOException e) {

                }
            }
        });

        return rootView;
    }



}
