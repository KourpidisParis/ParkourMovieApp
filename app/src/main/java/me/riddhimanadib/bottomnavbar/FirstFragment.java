package me.riddhimanadib.bottomnavbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import me.riddhimanadib.bottomnavbar.Cineplexx.Cineplexx;
import me.riddhimanadib.bottomnavbar.Village.VillageCosmos;

/**
 * Created by Adib on 13-Apr-17.
 */

public class FirstFragment extends Fragment {

    private OnFragmentInteractionListener listener;

    public static FirstFragment newInstance() {
        return new FirstFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_first, container, false);


        Button btn = (Button) view.findViewById(R.id.village);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Village", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(getActivity(), VillageCosmos.class);
                startActivity(in);
            }

        });

        Button btn2 = (Button) view.findViewById(R.id.cplxx);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Cineplexx", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(getActivity(), Cineplexx.class);
                startActivity(in);
            }

        });




        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface OnFragmentInteractionListener {
    }

}
