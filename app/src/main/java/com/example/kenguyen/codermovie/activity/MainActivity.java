package com.example.kenguyen.codermovie.activity;

import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.kenguyen.codermovie.Api.MovieApi;
import com.example.kenguyen.codermovie.Api.MovieApi_trailer;
import com.example.kenguyen.codermovie.R;
import com.example.kenguyen.codermovie.Utils.Constant;
import com.example.kenguyen.codermovie.Utils.RetrofitUtils;
import com.example.kenguyen.codermovie.adapter.MovieAdapter;
import com.example.kenguyen.codermovie.model.Movie;
import com.example.kenguyen.codermovie.model.NowPlaying;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.y;
import static android.R.id.list;
import static android.view.View.GONE;
import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
    private ListView lvMovie;
    private  MovieApi mMovieApi;
    private MovieApi_trailer movieApi_trailer;

    private ProgressBar pbLoading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMovieApi = RetrofitUtils.get(getString(R.string.api_key)).create(MovieApi.class);
        movieApi_trailer = RetrofitUtils.get(getString(R.string.api_key)).create(MovieApi_trailer.class);
        lvMovie = (ListView) findViewById(R.id.lvMovie);
        pbLoading = (ProgressBar) findViewById(R.id.pbLoading);

        if(savedInstanceState == null){
            fetchMovies();
        }
        else{
         savedInstanceState.get(String.valueOf(mMovieApi));
            mMovieApi.getNowlaying();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    private void fetchMovies(){
        mMovieApi.getNowlaying().enqueue(new Callback<NowPlaying>() {
            @Override
            public void onResponse(Call<NowPlaying> call, Response<NowPlaying> response) {
                handleResponse(response);
            }

            @Override
            public void onFailure(Call<NowPlaying> call, Throwable t) {
                Log.e("Error",t.getMessage());

            }
        });
    }
    public void onVideoTrailer(View view){
        Toast.makeText(this,"ontrailer",Toast.LENGTH_SHORT).show();
        movieApi_trailer.getNowlaying().enqueue(new Callback<NowPlaying>() {
            @Override
            public void onResponse(Call<NowPlaying> call, Response<NowPlaying> response) {

            }

            @Override
            public void onFailure(Call<NowPlaying> call, Throwable t) {
                Log.e("Error",t.getMessage());

            }
        });
    }
    private void handleResponse(Response<NowPlaying> response){
        lvMovie.setAdapter(new MovieAdapter(this,response.body().getMovies()));
        pbLoading.setVisibility(View.GONE);
    }
}
