package com.crnkic.a20210621_dzemalcrnkic_nycschools.network;

import com.crnkic.a20210621_dzemalcrnkic_nycschools.model.SATScores;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.model.Schools;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("resource/s3k6-pzi2.json")
    Call<List<Schools>> getSchools();

    @GET("resource/f9bf-2cp4.json")
    Call<List<SATScores>> getSATScores();
}
