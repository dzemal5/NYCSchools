package com.crnkic.a20210621_dzemalcrnkic_nycschools.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;

    private static String BASE_URL = "https://data.cityofnewyork.us/";

    public static Retrofit getRetrofit() {
        if(retrofit==null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;

    }


}
