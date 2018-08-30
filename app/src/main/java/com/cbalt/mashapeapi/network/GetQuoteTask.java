package com.cbalt.mashapeapi.network;

import android.os.AsyncTask;

import com.cbalt.mashapeapi.models.Quote;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class GetQuoteTask extends AsyncTask<String, Void, Quote[]> {

    @Override
    protected Quote[] doInBackground(String... strings) {

        QuotesConnection connection = new Interceptor().getConnection();
        Call<Quote[]> call = connection.quotesCall(strings[0]);

        try {
            Response<Quote[]> response = call.execute();
            if(200 == response.code() && response.isSuccessful()){
                return response.body();
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
