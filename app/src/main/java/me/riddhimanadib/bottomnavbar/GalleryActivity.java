package me.riddhimanadib.bottomnavbar;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

/**
 * Created by User on 1/2/2018.
 */

public class GalleryActivity extends AppCompatActivity {

    private static final String TAG = "GalleryActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Log.d(TAG, "onCreate: started.");

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name") ){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            String releaseDate = getIntent().getStringExtra("release_date");
            String overview = getIntent().getStringExtra("overview");

            setImage(imageUrl, imageName,releaseDate,overview);
        }
    }


    private void setImage(String imageUrl, String imageName,String releaseDate,String ovView){
        Log.d(TAG, "setImage: setting te image and name to widgets.");

        TextView name = findViewById(R.id.image_description);
        name.setText(imageName);

        TextView release = findViewById(R.id.release_date);
        release.setText(releaseDate);

        TextView overview = findViewById(R.id.overview);
        overview.setText(ovView);

        ImageView image = findViewById(R.id.image);
        Picasso.get().load(imageUrl).into(image);
//        Glide.with(this)
//                .asBitmap()
//                .load(imageUrl)
//                .into(image);
    }

}


















