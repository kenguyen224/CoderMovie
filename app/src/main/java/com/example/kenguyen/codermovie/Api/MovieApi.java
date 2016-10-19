package com.example.kenguyen.codermovie.Api;

import com.example.kenguyen.codermovie.model.NowPlaying;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by KeNguyen on 14/10/2016.
 */

public interface MovieApi {
    @GET("now_playing")
    Call<NowPlaying> getNowlaying();
}
