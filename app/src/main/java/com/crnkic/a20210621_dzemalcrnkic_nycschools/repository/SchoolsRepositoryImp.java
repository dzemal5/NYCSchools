package com.crnkic.a20210621_dzemalcrnkic_nycschools.repository;

import androidx.lifecycle.MutableLiveData;

import com.crnkic.a20210621_dzemalcrnkic_nycschools.model.SATScores;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.model.Schools;

import java.util.List;

public interface SchoolsRepositoryImp {
    MutableLiveData<List<Schools>> fetchDataForSchools();
    MutableLiveData<List<SATScores>> fetchDataForSATScores(String dbn);
}
