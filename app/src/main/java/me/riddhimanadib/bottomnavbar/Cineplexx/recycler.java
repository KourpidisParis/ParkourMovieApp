package me.riddhimanadib.bottomnavbar.Cineplexx;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import me.riddhimanadib.bottomnavbar.R;
import me.riddhimanadib.bottomnavbar.RecyclerViewAdapter;

public class recycler extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<Movie2> Movies = new ArrayList<>();
    private Context mContext;

    public recycler(Context context, ArrayList<Movie2> movies ) {
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
        Log.d(TAG, "onBindViewHolder: called.");



        Glide.with(mContext)
                .asBitmap()
                .load(Movies.get(position).getUrlImage())
                .into(holder.image);

        holder.imageName.setText(Movies.get(position).getTitle());
        holder.date.setText("Today");
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + Movies.get(position).getTitle());

                Toast.makeText(mContext, Movies.get(position).getTitle(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, DetailsCineplexx.class);
                intent.putExtra("imageDescription", Movies.get(position).getTitle());
                intent.putExtra("imageUrl",Movies.get(position).getUrlImage());

                //Making tables with time,date,mode
                ArrayList<String> hall = new ArrayList<>();

                for( Date d : Movies.get(position).getDates())
                {

                    hall.add(d.getHall()+" : "+d.getTime()+"("+d.getMode()+")");
                }

                intent.putExtra("halls",hall);
                intent.putExtra("urls",Movies.get(position).getUrl());

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Movies.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;
        TextView date;

        public ViewHolder(View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.date);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.movie_village2);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}




