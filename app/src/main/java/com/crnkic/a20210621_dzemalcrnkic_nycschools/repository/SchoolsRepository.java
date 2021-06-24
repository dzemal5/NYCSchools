package com.crnkic.a20210621_dzemalcrnkic_nycschools.repository;

import androidx.lifecycle.MutableLiveData;

import com.crnkic.a20210621_dzemalcrnkic_nycschools.model.SATScores;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.model.Schools;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.network.GetDataService;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.di.RetrofitClient;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SchoolsRepository implements SchoolsRepositoryImp {
    //    @Inject Constructor<GetDataService> getDataService;
    GetDataService getDataService;

    @Inject
    public SchoolsRepository(GetDataService getDataService) {
        this.getDataService = getDataService;
    }

    List<Schools> schoolsList = new ArrayList<>();
    List<SATScores> satScoresList = new ArrayList<>();

    private final MutableLiveData<List<Schools>> schoolsLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<SATScores>> satScoresLiveData = new MutableLiveData<>();

//    public LiveData<List<Schools>> getSchools() {
//        if (schoolsLiveData == null) {
//            schoolsLiveData = new MutableLiveData<List<Schools>>();
//        }
//        return schoolsLiveData;
//    }
//
//    public LiveData<List<SATScores>> getSATScores() {
//        if (satScoresLiveData == null) {
//            satScoresLiveData = new MutableLiveData<List<SATScores>>();
//        }
//        return satScoresLiveData;
//    }

    public MutableLiveData<List<Schools>> fetchDataForSchools() {
        getDataService = RetrofitClient.provideRetrofit().create(GetDataService.class);
        Call<List<Schools>> callSchools = getDataService.getSchools();

        callSchools.enqueue(new Callback<List<Schools>>() {
            @Override
            public void onResponse(@NotNull Call<List<Schools>> call, @NotNull Response<List<Schools>> response) {
                try {
                    schoolsLiveData.setValue(response.body());

//                    schoolsLiveData.postValue(schoolsList);
                } catch (Exception e) {
                    System.out.println(Arrays.toString(e.getStackTrace()));
                }
            }

            @Override
            public void onFailure(Call<List<Schools>> call, Throwable t) {

            }
        });
        return schoolsLiveData;
    }

    public MutableLiveData<List<SATScores>> fetchDataForSATScores(String dbn) {
        getDataService = RetrofitClient.provideRetrofit().create(GetDataService.class);
        Call<List<SATScores>> callSchools = getDataService.getSATScores(dbn);

        callSchools.enqueue(new Callback<List<SATScores>>() {
            @Override
            public void onResponse(@NotNull Call<List<SATScores>> call, @NotNull Response<List<SATScores>> response) {
                try {
                    satScoresLiveData.setValue(response.body());
//                    satScoresLiveData.postValue(satScoresList);
                } catch (Exception e) {
                    System.out.println(Arrays.toString(e.getStackTrace()));
                }
            }

            @Override
            public void onFailure(Call<List<SATScores>> call, Throwable t) {

            }
        });
        return  satScoresLiveData;
    }
}
