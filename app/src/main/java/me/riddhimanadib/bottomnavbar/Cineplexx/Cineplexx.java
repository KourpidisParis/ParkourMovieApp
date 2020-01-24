package me.riddhimanadib.bottomnavbar.Cineplexx;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

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

public class Cineplexx extends AppCompatActivity {
    private static final String TAG ="Cineplexx" ;
    private ArrayList<Movie2> movies2 = new ArrayList<>();
    private TextView temp;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cineplexx_activity);

        new c2().execute();

    }



    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recycler adapter = new recycler (this, movies2);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public class c2 extends AsyncTask<Void,Void,Void> {


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            initRecyclerView();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try{
                final Document document = Jsoup.connect("https://www.cineplexx.gr/tainies/").get();
                //System.out.println(document.outerHtml());

                Elements details = document.select("div.detailview-element");
                Elements rows = details.select(".row");

                for(Element r :rows) {

                    Elements spans =  r.select(".span6");


                    Element span1 = spans.get(0);
                    String imgUrl = span1.select("img").attr("data-original");
                    String imgUrl2 = "https:"+imgUrl;

                    String url = span1.select("h2 a").attr("href");

                    String title = span1.select("h2 a").text();


                    Movie2 movie = new Movie2(title,url,imgUrl2);

                    Element span2 = spans.get(1);
                    Elements subSpans = span2.select(".span3");

                    for(Element s : subSpans)
                    {

                        String hall = s.select("p.room-desc").text();
                        String time =  s.select("p.time-desc").text();
                        String mode = s.select("p.mode-desc").text();


                        Date date = new Date(hall,time,mode);
                        movie.addDate(date);
                    }
                    //	System.out.println(subspan.outerHtml());
                    System.out.println(movie.getTitle());
                    System.out.println(movie.getUrl());
                    System.out.println(movie.getUrlImage());

                    for(Date d : movie.getDates() )
                    {
                        System.out.print(d.getHall() + "==> ");
                        System.out.print(d.getTime() +" ");
                        System.out.println(d.getMode());
                    }
                    movies2.add(movie);
                }

            }catch (IOException e)
            {
                e.printStackTrace();
            }
            return null;


        }


    }


}