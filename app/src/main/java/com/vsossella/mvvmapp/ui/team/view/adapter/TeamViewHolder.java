package com.vsossella.mvvmapp.ui.team.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.vsossella.mvvmapp.databinding.TeamViewBinding;
import com.vsossella.mvvmapp.ui.team.model.Team;

/**
 * Created by vsossella on 26/06/17.
 */

public class TeamViewHolder extends RecyclerView.ViewHolder {

    TeamViewBinding binding;

    public TeamViewHolder(View itemView, TeamViewBinding binding) {
        super(itemView);
        this.binding = binding;
    }

    public void bindTeam(Team team) {
        this.binding.setViewModel(team);
        this.binding.executePendingBindings();
    }

}
