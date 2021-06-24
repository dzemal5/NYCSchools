package com.crnkic.a20210621_dzemalcrnkic_nycschools.ui.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crnkic.a20210621_dzemalcrnkic_nycschools.databinding.DetailsFragmentBinding;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.model.SATScores;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.model.Schools;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.ui.viewModel.SchoolsViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DetailsFragment extends Fragment {

    private DetailsFragmentBinding viewBinding;

    SchoolsViewModel schoolsViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        schoolsViewModel = new ViewModelProvider(this).get(SchoolsViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewBinding = DetailsFragmentBinding.inflate(inflater, container, false);
        return viewBinding.getRoot();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        assert getArguments() != null;
        Schools schools = DetailsFragmentArgs.fromBundle(getArguments()).getSchool();
        schoolsViewModel.fetchData(schools.dbn);

        schoolsViewModel.getSATScores(schools.dbn).observe(getViewLifecycleOwner(), new Observer<List<SATScores>>() {
            @Override
            public void onChanged(List<SATScores> satScores) {
                viewBinding.schoolName.setText("MAth score is "+(schoolsViewModel.getSATScores(schools.dbn).getValue().get(0).sat_math_avg_score));

            }
        });
    }
}