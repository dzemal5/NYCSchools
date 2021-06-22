package com.crnkic.a20210621_dzemalcrnkic_nycschools.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crnkic.a20210621_dzemalcrnkic_nycschools.R;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.databinding.DetailsFragmentBinding;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.databinding.ListFragmentBinding;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.ui.SchoolsViewModel;

import org.jetbrains.annotations.NotNull;

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

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}