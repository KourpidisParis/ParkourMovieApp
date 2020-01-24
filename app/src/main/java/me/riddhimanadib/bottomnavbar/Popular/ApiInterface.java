package me.riddhimanadib.bottomnavbar.Popular;

import me.riddhimanadib.bottomnavbar.MovieResults;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("/3/movie/{category}")
    Call<MovieResults> listOfMovies(
      @Path("category") String category,
      @Query("api_key") String apiKey,
      @Query("language") String language,
      @Query("page") int page
    );





//    https://api.themoviedb.org/3/movie/popular?api_key=6beea1ff061d20f9b43c823acbaeb040&language=en-US&page=1

}
