package com.vsossella.mvvmapp.bindingadapters;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.vsossella.mvvmapp.ui.team.model.Team;
import com.vsossella.mvvmapp.ui.team.view.adapter.TeamsAdapter;

/**
 * Created by vsossella on 26/06/17.
 */

public class TeamBindingAdapters {

    @BindingAdapter("bind:teams")
    public static void bindTeams(final RecyclerView view, ObservableArrayList<Team> list) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        view.setLayoutManager(layoutManager);
        view.setAdapter(new TeamsAdapter(list, view.getContext()));
    }

}
