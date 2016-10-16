package com.example.kenguyen.codermovie.Api;

import com.example.kenguyen.codermovie.model.NowPlaying;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by KeNguyen on 15/10/2016.
 */

public interface MovieApi_trailer {
    @GET("trailers")
    Call<NowPlaying> getNowlaying();
}
