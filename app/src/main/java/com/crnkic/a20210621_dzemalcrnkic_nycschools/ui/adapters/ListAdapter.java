package com.crnkic.a20210621_dzemalcrnkic_nycschools.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.databinding.ListFragmentCardviewBinding;
import com.crnkic.a20210621_dzemalcrnkic_nycschools.model.Schools;
import org.jetbrains.annotations.NotNull;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.CardViewHolder> {
    private ListFragmentCardviewBinding viewBinding;
    private GetPosition getPosition;

    public void setGetPosition(GetPosition getPosition) {
        this.getPosition = getPosition;
    }

    List<Schools> schools;

    public ListAdapter(List<Schools> schools) {
        this.schools = schools;
    }

    @NotNull
    @Override
    public CardViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        viewBinding = ListFragmentCardviewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CardViewHolder(viewBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CardViewHolder holder, int position) {
        holder.viewBiding.schoolName.setText(schools.get(position).school_name);
        holder.viewBiding.boro.setText(schools.get(position).borough);
        holder.viewBiding.website.setText(schools.get(position).website);
    }

    @Override
    public int getItemCount() {
        return schools.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ListFragmentCardviewBinding viewBiding;

        public CardViewHolder(@NonNull @NotNull ListFragmentCardviewBinding binding) {
            super(binding.getRoot());
            viewBiding = binding;
            viewBiding.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getPosition.onClick(getAdapterPosition());
                }
            });
        }
    }
}

