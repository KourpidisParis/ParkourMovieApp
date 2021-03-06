package me.riddhimanadib.bottomnavbar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

import me.riddhimanadib.library.BottomBarHolderActivity;
import me.riddhimanadib.library.NavigationPage;

public class MainActivity extends BottomBarHolderActivity implements FirstFragment.OnFragmentInteractionListener, SearchFragment.OnFragmentInteractionListener {

    public SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        NavigationPage page1 = new NavigationPage("Home", ContextCompat.getDrawable(this, R.drawable.ic_home_black_24dp), FirstFragment.newInstance());
        NavigationPage page2 = new NavigationPage("Search", ContextCompat.getDrawable(this, R.drawable.ic_search_black_24dp), SearchFragment.newInstance());
        NavigationPage page3 = new NavigationPage("Popular", ContextCompat.getDrawable(this, R.drawable.ic_assessment_black_24dp), ThirdFragment.newInstance());
        NavigationPage page4 = new NavigationPage("Database", ContextCompat.getDrawable(this, R.drawable.ic_person_black_24dp), FourthFragment.newInstance());

        List<NavigationPage> navigationPages = new ArrayList<>();
        navigationPages.add(page1);
        navigationPages.add(page2);
        navigationPages.add(page3);
        navigationPages.add(page4);

        super.setupBottomBarHolderActivity(navigationPages);
        db = getBaseContext().openOrCreateDatabase(
                "parkourApp",
                Context.MODE_PRIVATE,
                null);

        db.execSQL("CREATE TABLE IF NOT EXISTS Person(name text not null )");

    }







    @Override
    public void onClicked() {
        Toast.makeText(this, "Clicked!", Toast.LENGTH_SHORT).show();
    }
}