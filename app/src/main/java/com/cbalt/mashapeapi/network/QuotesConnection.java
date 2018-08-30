package com.cbalt.mashapeapi.network;

import com.cbalt.mashapeapi.models.Quote;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface QuotesConnection {

    @POST("?cat=movies")
    Call<Quote[]> quotesCall(@Header("X-Mashape-Key") String mashapeKey);
}
