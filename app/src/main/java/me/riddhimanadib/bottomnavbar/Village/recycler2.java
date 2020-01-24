package me.riddhimanadib.bottomnavbar.Village;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import me.riddhimanadib.bottomnavbar.R;
import me.riddhimanadib.bottomnavbar.RecyclerViewAdapter;

public class recycler2 extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<Movie> Movies = new ArrayList<>();
    private Context mContext;

    public recycler2(Context context, ArrayList<Movie> movies) {
        Movies = movies;
        mContext = context;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        RecyclerViewAdapter.ViewHolder holder = new RecyclerViewAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, final int position) {


        holder.imageName.setText(Movies.get(position).getMovie());
        holder.date.setText("");


        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, Movies.get(position).getMovie(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, DetailsVillage.class);
                intent.putExtra("title", Movies.get(position).getMovie());

                ArrayList<String> dates = new ArrayList<>();
                for( Theater t : Movies.get(position).getTheater())
                {
                    dates.add(t.getTheater()+", "+ t.getDate()+" "+t.getTimes());
                }

                intent.putExtra("dates",dates);
                mContext.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return Movies.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public RelativeLayout parentL;
        public TextView date;

        public ViewHolder(View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.date);
            title = itemView.findViewById(R.id.movie_village2);
            parentL = itemView.findViewById(R.id.parent_layout2);
        }
    }
}




