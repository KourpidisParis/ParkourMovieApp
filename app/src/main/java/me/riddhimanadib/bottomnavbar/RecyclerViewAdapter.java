package me.riddhimanadib.bottomnavbar;

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


/**
 * Created by User on 1/1/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mTitle = new ArrayList<>();
    private ArrayList<String> mImageUrl = new ArrayList<>();
    private ArrayList<String> mReleaseDate = new ArrayList<>();
    private ArrayList<String> mOverview = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<String> imageNames, ArrayList<String> images,ArrayList<String> releaseDate,ArrayList<String> overview ) {
        mTitle = imageNames;
        mImageUrl = images;
        mContext = context;
        mReleaseDate = releaseDate;
        mOverview = overview;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(mImageUrl.get(position))
                .into(holder.image);

        holder.imageName.setText(mTitle.get(position));
        holder.date.setText(mReleaseDate.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mTitle.get(position));

                Toast.makeText(mContext, mTitle.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, GalleryActivity.class);
                intent.putExtra("image_url", mImageUrl.get(position));
                intent.putExtra("image_name", mTitle.get(position));
                intent.putExtra("release_date",mReleaseDate.get(position));
                intent.putExtra("overview",mOverview.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTitle.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        public CircleImageView image;
        public TextView imageName;
        public RelativeLayout parentLayout;
        public TextView date;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.movie_village2);
            date = itemView.findViewById(R.id.date);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}

















