package me.riddhimanadib.bottomnavbar.Village;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import me.riddhimanadib.bottomnavbar.R;

public class DetailsVillage extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_village);

        getIncomingIntent();
    }

    private void getIncomingIntent(){

        if(getIntent().hasExtra("title") ){

            String title = getIntent().getStringExtra("title");
            ArrayList<String> dates = getIntent().getStringArrayListExtra("dates");


            setLayout(title,dates);
        }
    }


    private void setLayout(String movieName,ArrayList<String> dates ){

        TextView name = findViewById(R.id.namev);
        name.setText(movieName);




        ListView list = (ListView)findViewById(R.id.second_list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dates);
        list.setAdapter(arrayAdapter);


    }
}


