package me.riddhimanadib.bottomnavbar;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface2 {
    @GET("/3/search/movie/")
    Call<MovieResults> listOfMovies(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("query") String query,
            @Query("page") int page,
            @Query("include_adult") boolean adult
    );

    //https://api.themoviedb.org/3/search/movie?api_key=6beea1ff061d20f9b43c823acbaeb040&language=en-US&query=Joker&page=1&include_adult=false


}
