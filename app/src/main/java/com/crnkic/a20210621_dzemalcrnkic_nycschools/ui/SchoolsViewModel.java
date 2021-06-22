package com.crnkic.a20210621_dzemalcrnkic_nycschools.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.crnkic.a20210621_dzemalcrnkic_nycschools.model.Schools;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.network.GetDataService;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.network.RetrofitClient;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SchoolsViewModel extends ViewModel {

    List<Schools> schoolsList = new ArrayList<>();

    private MutableLiveData<List<Schools>> schoolsLiveData;

    public LiveData<List<Schools>> getSchools() {
        if (schoolsLiveData == null) {
            schoolsLiveData = new MutableLiveData<List<Schools>>();
        }
        return schoolsLiveData;
    }

    public void fetchDataForSchools() {
        GetDataService getDataService = RetrofitClient.getRetrofit().create(GetDataService.class);
        Call<List<Schools>> callSchools = getDataService.getSchools();

        callSchools.enqueue(new Callback<List<Schools>>() {
            @Override
            public void onResponse(@NotNull Call<List<Schools>> call, @NotNull Response<List<Schools>> response) {
                schoolsList = response.body();
                schoolsLiveData.postValue(schoolsList);

            }

            @Override
            public void onFailure(Call<List<Schools>> call, Throwable t) {

            }
        });
    }

    public void fetchDataForSATScores () {

    }

}