package me.riddhimanadib.bottomnavbar.Cineplexx;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import me.riddhimanadib.bottomnavbar.R;

public class DetailsCineplexx extends AppCompatActivity {


    private static final String TAG = "GalleryActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_cineplexx);
        Log.d(TAG, "onCreate: started.");

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if(getIntent().hasExtra("imageDescription") ){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String imageName = getIntent().getStringExtra("imageDescription");
            String url = getIntent().getStringExtra("imageUrl");
            ArrayList<String> hall = getIntent().getStringArrayListExtra("halls");
            String urlMovie = getIntent().getStringExtra("urls");


            setLayout(imageName,url, hall,urlMovie);
        }
    }


    private void setLayout(String movieName,String imageUrl,ArrayList<String> hall,String urlMovie ){
        Log.d(TAG, "setImage: setting te image and name to widgets.");

        TextView name = findViewById(R.id.namev);
        name.setText(movieName);

        ImageView image = findViewById(R.id.imageCineplex);
        Picasso.get()
                .load(imageUrl)
                .resize(80, 112) // resizes the image to these dimensions (in pixel). does not respect aspect ratio
                .into(image);
//        Picasso.get().load(imageUrl).into(image);

        TextView h = findViewById(R.id.link);

        TextView link = (TextView)findViewById(R.id.link);
        link.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                Intent browser= new Intent(Intent.ACTION_VIEW, Uri.parse("https:"+urlMovie));
                startActivity(browser);
            }

        });

        ListView list = (ListView)findViewById(R.id.second_list);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,hall);
        list.setAdapter(arrayAdapter);



//        Picasso.get().load(imageUrl).into(image);
//        Glide.with(this)
//                .asBitmap()
//                .load(imageUrl)
//                .into(image);
    }
}
