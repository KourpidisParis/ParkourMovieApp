package me.riddhimanadib.bottomnavbar.Popular;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import me.riddhimanadib.bottomnavbar.MovieResults;
import me.riddhimanadib.bottomnavbar.R;
import me.riddhimanadib.bottomnavbar.RecyclerViewAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PopularMovies extends AppCompatActivity {
    private static final String TAG = "MainActivity";


    public static String BASE_URL = " https://api.themoviedb.org";
    public static String BASE_IMAGE_URL ="https://image.tmdb.org/t/p/w500";

    public static int PAGE = 1;
    public static String API_KEY = "6beea1ff061d20f9b43c823acbaeb040";
    public static String LANGUAGE = "en-US";
    public static String CATEGORY = "popular";
    public static String MOVIE_NAME ="";
    public static boolean ADULT = false;

    //vars
    private ArrayList<String> title = new ArrayList<>();
    private ArrayList<String> imageUrl = new ArrayList<>();
    private ArrayList<String> releaseDate = new ArrayList<>();
    private ArrayList<String> overview = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base);
        Log.d(TAG, "onCreate: started.");


        Intent intent = getIntent();
        String name = intent.getStringExtra("text");
        MOVIE_NAME = name;


        PopularMovies();
    }



    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, title, imageUrl,releaseDate,overview);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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
                for(int i =0; i<listOfMovies.size(); i++)
                {
                    title.add(listOfMovies.get(i).getTitle());
                    imageUrl.add(BASE_IMAGE_URL+listOfMovies.get(i).getPoster_path());
                    releaseDate.add(listOfMovies.get(i).getRelease_date());
                    overview.add(listOfMovies.get(i).getOverview());
                }
                initRecyclerView();
            }

            @Override
            public void onFailure(Call<MovieResults> call, Throwable t) {


            }
        });


    }

}





