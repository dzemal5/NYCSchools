package com.crnkic.a20210621_dzemalcrnkic_nycschools.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.crnkic.a20210621_dzemalcrnkic_nycschools.databinding.ListFragmentBinding;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.model.Schools;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.ui.SchoolsViewModel;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.ui.adapters.GetPosition;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.ui.adapters.ListAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ListFragment extends Fragment {

    SchoolsViewModel schoolsViewModel;
    private ListFragmentBinding viewBinding;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        schoolsViewModel = new ViewModelProvider(this).get(SchoolsViewModel.class);
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        viewBinding = ListFragmentBinding.inflate(inflater, container, false);
        return viewBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        schoolsViewModel.fetchDataForSchools();
        schoolsViewModel.getSchools().observe(getViewLifecycleOwner(), this::getSchoolsList);
    }

    public void getSchoolsList(List<Schools> schools) {
        ListAdapter listAdapter = new ListAdapter(schools);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        viewBinding.recyclerViewListFragment.setLayoutManager(layoutManager);
        viewBinding.recyclerViewListFragment.setAdapter(listAdapter);

        listAdapter.setGetPosition(new GetPosition() {
            @Override
            public void onClick(int position) {
                NavDirections action =ListFragmentDirections.actionListFragmentToDetailsFragment(position);
                Navigation.findNavController(viewBinding.recyclerViewListFragment).navigate(action);

                Toast.makeText(getContext(), "position = " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        viewBinding = null;
    }
}