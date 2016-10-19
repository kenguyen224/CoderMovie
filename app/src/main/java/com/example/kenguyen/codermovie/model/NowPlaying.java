package com.example.kenguyen.codermovie.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by KeNguyen on 13/10/2016.
 */

public class NowPlaying {
    @SerializedName("results")
    private List<Movie>movies;

    public List<Movie> getMovies() {
        return movies;
    }
}
