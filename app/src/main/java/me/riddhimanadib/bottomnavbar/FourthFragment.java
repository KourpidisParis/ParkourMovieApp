package me.riddhimanadib.bottomnavbar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/**
 * Created by Adib on 13-Apr-17.
 */

public class FourthFragment extends Fragment{

    public static FourthFragment newInstance() {
        return new FourthFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_fourth, container, false);
            return view;

    }


}
