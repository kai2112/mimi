package activity;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.candle.mimi.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by kai on 2016/07/15.
 */
public class DetailActivity extends Activity {
    ImageView thumbnailImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        thumbnailImage = (ImageView)findViewById(R.id.thumbnail_image);

        try {
            AssetManager assetManager = getResources().getAssets();
            InputStream inputStream = assetManager.open("sample_thumbnail.png");
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            thumbnailImage.setImageBitmap(bitmap);
        } catch (IOException e) {

        }
    }
}
