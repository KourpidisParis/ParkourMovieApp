package me.riddhimanadib.bottomnavbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Results extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        Intent intent = getIntent();

        TextView txtGreeting = (TextView)findViewById(R.id.txtGreeting);

        String givenName = intent.getStringExtra("text");

        txtGreeting.setText("Text, "+givenName+ " !!");
    }
}
