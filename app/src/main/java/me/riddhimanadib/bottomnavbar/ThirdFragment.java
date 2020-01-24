package me.riddhimanadib.bottomnavbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import me.riddhimanadib.bottomnavbar.Popular.PopularMovies;

/**
 * Created by Adib on 13-Apr-17.
 */

public class ThirdFragment extends Fragment {


    public static ThirdFragment newInstance() {
        return new ThirdFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_third, container, false);
        Button btn = (Button) view.findViewById(R.id.buttonPop);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), PopularMovies.class);
                startActivity(in);
            }
        });

        return view;
    }

}
