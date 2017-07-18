package com.vsossella.mvvmapp.ui.team.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.vsossella.mvvmapp.R;
import com.vsossella.mvvmapp.databinding.TeamViewBinding;
import com.vsossella.mvvmapp.ui.team.model.Team;

import java.util.List;

/**
 * Created by vsossella on 26/06/17.
 */

public class TeamsAdapter extends RecyclerView.Adapter<TeamViewHolder> {

    List<Team> teams;
    Context context;
    TeamViewBinding binding;
    LayoutInflater inflater;

    public TeamsAdapter(List<Team> teams, Context context) {
        super();
        this.teams = teams;
        this.context = context;
    }

    @Override
    public TeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(context);
        }
        binding = DataBindingUtil.inflate(inflater, R.layout.team_view, parent, false);
        return new TeamViewHolder(binding.getRoot(), binding);
    }

    @Override
    public void onBindViewHolder(TeamViewHolder holder, int position) {
        holder.bindTeam(teams.get(position));
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }
}
