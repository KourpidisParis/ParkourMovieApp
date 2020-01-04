package me.riddhimanadib.bottomnavbar;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Results extends AppCompatActivity {
    private static final String TAG = "MainActivity";


    public static String BASE_URL = " https://api.themoviedb.org";
    public static String BASE_IMAGE_URL ="https://image.tmdb.org/t/p/w500";

    public static int PAGE = 1;
    public static String API_KEY = "6beea1ff061d20f9b43c823acbaeb040";
    public static String LANGUAGE = "en-US";
    public static String CATEGORY = "popular";
    public static String MOVIE_NAME ="";
    public static boolean ADULT = false;

    private TextView myTextView;
    private TextView myTextView2;
    private TextView myTextView3;
    private ImageView myImage;

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base);
        Log.d(TAG, "onCreate: started.");



//        myTextView = (TextView) findViewById(R.id.title);
//        myTextView2 = (TextView) findViewById(R.id.release_date);
//        myTextView3 = (TextView) findViewById(R.id.overview);
//
//        myImage  =(ImageView) findViewById(R.id.image_view);



        Intent intent = getIntent();
        String name = intent.getStringExtra("text");
        MOVIE_NAME = name;


        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        mNames.add("Havasu Falls");

        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("Trondheim");

        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Portugal");

        mImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        mNames.add("Rocky Mountain National Park");


        mImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mNames.add("Mahahual");

        mImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
        mNames.add("Frozen Lake");


        mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        mNames.add("White Sands Desert");

        mImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
        mNames.add("Austrailia");

        mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
        mNames.add("Washington");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    public void searchMovies(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface2 myInterface = retrofit.create(ApiInterface2.class);

        Call<MovieResults> call = myInterface.listOfMovies(API_KEY,LANGUAGE,MOVIE_NAME,PAGE,ADULT);
        call.enqueue(new Callback<MovieResults>() {
            @Override
            public void onResponse(Call<MovieResults> call, Response<MovieResults> response) {
                MovieResults results = response.body();
                List<MovieResults.ResultsBean> listOfMovies = results.getResults();
                MovieResults.ResultsBean firstMovie = listOfMovies.get(0);

//                for( MovieResults.ResultsBean m : listOfMovies) {
//                    //Movie movie = new Movie(m.getTitle(),m.getRelease_date(),m.getPoster_path(),m.getOverview());
//                    movieList.add(new Movie(m.getTitle(),m.getRelease_date(),m.getPoster_path(),m.getOverview()));
//                }

//                myTextView.setText(movieList.get(1).getTitle());
//                myTextView2.setText(movieList.get(1).getReleaseDate());
//                myTextView3.setText(movieList.get(1).getOverview());
//                String url = BASE_IMAGE_URL+movieList.get(1).getUrlImage();
//                Picasso.get().load(url).into(myImage);
            }

            @Override
            public void onFailure(Call<MovieResults> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }


    public void PopularMovies(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        ApiInterface myInterface = retrofit.create(ApiInterface.class);
        Call<MovieResults> call = myInterface.listOfMovies(CATEGORY,API_KEY,LANGUAGE,PAGE);

        call.enqueue(new Callback<MovieResults>() {
            @Override
            public void onResponse(Call<MovieResults> call, Response<MovieResults> response) {
                MovieResults results = response.body();
                List<MovieResults.ResultsBean> listOfMovies = results.getResults();
                MovieResults.ResultsBean firstMovie = listOfMovies.get(0);
                myTextView.setText(firstMovie.getTitle());
            }

            @Override
            public void onFailure(Call<MovieResults> call, Throwable t) {
                t.printStackTrace();

            }
        });


    }

}
