package com.crnkic.a20210621_dzemalcrnkic_nycschools.ui.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.crnkic.a20210621_dzemalcrnkic_nycschools.model.SATScores;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.model.Schools;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.repository.SchoolsRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class SchoolsViewModel extends ViewModel {
    SchoolsRepository schoolsRepository;

    @Inject
    public SchoolsViewModel(SchoolsRepository schoolsRepository) {
        super();
        isLoading.setValue(true);
        this.schoolsRepository = schoolsRepository;
        schoolsLiveData = schoolsRepository.fetchDataForSchools();
    }

    public void fetchData(String dbn) {
        satScoresLiveData = schoolsRepository.fetchDataForSATScores(dbn);

    }

    private final MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private MutableLiveData<List<Schools>> schoolsLiveData;
    private MutableLiveData<List<SATScores>> satScoresLiveData;

    public LiveData<Boolean> isLoading(){
        return isLoading;
    }

    public LiveData<List<Schools>> getSchools() {
        if (schoolsLiveData == null) {
            schoolsLiveData = new MutableLiveData<>();
        }
        return schoolsLiveData;
    }

    public LiveData<List<SATScores>> getSATScores(String dbn) {
        if (satScoresLiveData == null) {
            satScoresLiveData = new MutableLiveData<>();
            satScoresLiveData = schoolsRepository.fetchDataForSATScores(dbn);
        }
        return satScoresLiveData;
    }
}