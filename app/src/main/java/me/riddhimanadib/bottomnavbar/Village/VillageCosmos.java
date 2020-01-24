package me.riddhimanadib.bottomnavbar.Village;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import me.riddhimanadib.bottomnavbar.R;

public class VillageCosmos extends AppCompatActivity {
    private static final String TAG = "Village Activity";
    private ArrayList<Movie> movies = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.village_activity);

        new c2().execute();

    }


    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view3);
        recycler2 adapter = new recycler2(this, movies);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public class c2 extends AsyncTask<Void, Void, Void> {


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            initRecyclerView();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                String date = null;
                String time = null;
                String hallName = null;
                String movie;
                Theater t=null;

                final Document document = Jsoup.connect("https://www.villagecinemas.gr/el/kinimatografoi/cosmos-11-cinemas/").get();
                ArrayList<Element> title = new ArrayList<>();


                title = document.select("div.view");

                for (Element row: title)
                {

                    // title movies
                    movie  = row.select("div.cinema.FloatLeft h3").text();
                    Movie m = new Movie(movie);
                    //System.out.println(m.getMovie());

                    Elements views = row.select("div.view_details");
                    for(Element view : views)
                    {
                        hallName = view.select("div.hall_title").text();

                        Elements hall_row = view.select("div.hall_row.row");
                        for(Element h : hall_row) {
                            date = h.select("div.date.FloatLeft").text();
                            time = h.select("div.hour.FloatLeft").text();
                            t = new Theater (hallName,date,time);
                            m.addTheater(t);
                        }


                    }

                    movies.add(m);

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;


        }


    }


}