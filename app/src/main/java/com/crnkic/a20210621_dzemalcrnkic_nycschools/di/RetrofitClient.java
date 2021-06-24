package com.crnkic.a20210621_dzemalcrnkic_nycschools.di;

import com.crnkic.a20210621_dzemalcrnkic_nycschools.MainActivity;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.network.GetDataService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class RetrofitClient {
    private static Retrofit retrofit;

    private static String BASE_URL = "https://data.cityofnewyork.us/";

    @Provides
    @Singleton
    public static Retrofit provideRetrofit() {
        if(retrofit==null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;
    }

    @Provides
    @Singleton
    public static GetDataService provideDataService(Retrofit retrofit) {
        return retrofit.create(GetDataService.class);
    }








}
