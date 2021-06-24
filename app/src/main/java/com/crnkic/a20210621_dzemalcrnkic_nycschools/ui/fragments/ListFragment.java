package com.crnkic.a20210621_dzemalcrnkic_nycschools.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.crnkic.a20210621_dzemalcrnkic_nycschools.databinding.ListFragmentBinding;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.model.SATScores;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.model.Schools;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.repository.SchoolsRepository;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.ui.viewModel.SchoolsViewModel;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.ui.adapters.GetPosition;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.ui.adapters.ListAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
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

//        schoolsViewModel.getSchools().observe(getViewLifecycleOwner(), this::getSchoolsList);

        schoolsViewModel.getSchools().observe(getViewLifecycleOwner(), new Observer<List<Schools>>() {
            @Override
            public void onChanged(List<Schools> schools) {

                getSchoolsList(schools);

            }
        });
    }

    public void getSchoolsList(List<Schools> schools) {
        ListAdapter listAdapter = new ListAdapter(schools);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        viewBinding.recyclerViewListFragment.setLayoutManager(layoutManager);
        viewBinding.recyclerViewListFragment.setAdapter(listAdapter);

        listAdapter.setGetPosition(new GetPosition() {
            @Override
            public void onClick(Schools school) {
                NavDirections action = (NavDirections) ListFragmentDirections.actionListFragmentToDetailsFragment(school);
                Navigation.findNavController(viewBinding.recyclerViewListFragment).navigate(action);

                Toast.makeText(getContext(), "position = " + "position", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        viewBinding = null;
    }
}