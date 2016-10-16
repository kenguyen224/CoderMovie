package com.example.kenguyen.codermovie.adapter;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.kenguyen.codermovie.R;
import com.example.kenguyen.codermovie.model.Movie;

import java.util.List;

/**
 * Created by KeNguyen on 14/10/2016.
 */

public class MovieAdapter extends ArrayAdapter<Movie> {
    private List<Movie> mMovie;
    public MovieAdapter(Context context, List<Movie> movies  ) {
        super(context, -1);
        mMovie = movies;
    }

    @Override
    public int getCount() {
        return mMovie.size();
    }

    @Nullable
    @Override
    public Movie getItem(int position) {
        return mMovie.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_movie,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tv_Title);
            viewHolder.tvOverView = (TextView) convertView.findViewById(R.id.tv_Overview);
            viewHolder.ivCover = (ImageView) convertView.findViewById(R.id.iv_Cover);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Movie movie = getItem(position);

        //fill the data
        viewHolder.tvTitle.setText(movie.getTitle());
        viewHolder.tvOverView.setText(movie.getOverview());



        //Get configuration
        Configuration configuration = getContext().getResources().getConfiguration();
        if(configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
            Glide.with(getContext())
                    .load(movie.getPosterPath())
                    .placeholder(R.drawable.placeholder)
                    .into(viewHolder.ivCover);
        }
        else if(configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Glide.with(getContext())
                    .load(movie.getBackdropPath())
                    .placeholder(R.drawable.placeholder)
                    .into(viewHolder.ivCover);
        }

        return convertView;
    }
    public class ViewHolder{
        public TextView tvTitle;
        public TextView tvOverView;
        public ImageView ivCover;
    }
}
