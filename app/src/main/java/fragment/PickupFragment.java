package fragment;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.VideoView;

import com.example.candle.mimi.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.ArrayList;


/**
 * Created by kai on 2016/07/11.
 */
public class PickupFragment extends BaseFragment {
    private View rootView;
    private VideoView pickupVideo;
    private LinearLayout pickupThumbnailArea;





    private ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;

    public static PickupFragment newInstance() {
        return new PickupFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.pickup_fragment, container, false);

        pickupThumbnailArea = (LinearLayout)rootView.findViewById(R.id.pickup_thumbnail_area);
        AssetManager assetManager = getContext().getAssets();

        pickupVideo = (VideoView)rootView.findViewById(R.id.pickup_video);
//        pickupVideo.setVideoPath("file:///assets/kai_sample.mp4");
//        pickupVideo.setVideoURI(Uri.parse("android.resource://"+ getContext().getPackageName()+"/"+R.raw.kai_sample));
//        pickupVideo.setVideoURI(Uri.parse("android.resource://"+ getContext().getPackageName()+"/"+R.raw.n038_instagram));
        pickupVideo.setVideoPath("http://asset.mimitv.jp/sample/N038_Instagram_%E3%81%BE%E3%81%A4%E3%81%8D.mp4");






//        String uriStr = "";
//        try {
//            uriStr = URLDecoder.decode("http://asset.mimitv.jp/sample/N038_Instagram_%E3%81%BE%E3%81%A4%E3%81%8D.mp4", "UTF-8");
//            android.util.Log.d("kai", "uriStr = "+uriStr);
//        } catch (Exception e) {
//
//        }
//
//        pickupVideo.setVideoURI(Uri.parse("http://asset.mimitv.jp/sample/N038_Instagram_%E3%81%BE%E3%81%A4%E3%81%8D.mp4"));
//        pickupVideo.setVideoURI(Uri.parse(uriStr));
        pickupVideo.start();

        new Handler().post(new Runnable() {
            @Override
            public void run() {

                try {
                    AssetManager assetManager = getContext().getResources().getAssets();
                    InputStream inputStream = assetManager.open("sample_thumbnail.png");
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);


                    int thumbnailSize = pickupThumbnailArea.getWidth() / 2;
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

                    makeThumbnailAreaLayout(pickupThumbnailArea, sampleThumbnailList, BaseFragment.THUMBNAIL_2_LINE_ROW);
                } catch (IOException e) {

                }
            }
        });

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstaneState) {
        super.onViewCreated(view, savedInstaneState);
    }


    @Override
    public void onResume(){
        super.onResume();
    }

}
