package com.vsossella.mvvmapp.ui.team.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.view.View;

import com.vsossella.mvvmapp.api.CallbackListener;
import com.vsossella.mvvmapp.api.entity.team.TeamOutput;
import com.vsossella.mvvmapp.service.team.TeamService;
import com.vsossella.mvvmapp.ui.team.interaction.TeamActivityInteraction;
import com.vsossella.mvvmapp.ui.team.model.Team;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

/**
 * Created by vsossella on 26/06/17.
 */

public class TeamViewModel {

    ObservableArrayList<Team> teams = new ObservableArrayList<>();
    ObservableField<String> cityFilter = new ObservableField<>();
    TeamService teamService;
    TeamActivityInteraction interaction;

    @Inject
    public TeamViewModel(TeamService teamService) {
        this.teamService = teamService;
    }

    public void loadTeamsFromAPI() {
        interaction.showLoading();

        teamService.findAllTeams(new CallbackListener<List<TeamOutput>, String>() {
            @Override
            public void onResponseSuccess(List<TeamOutput> responseSuccess) {
                refreshList(responseSuccess);
                interaction.hideLoading();
                interaction.showToast("Teams loaded with success");
            }

            @Override
            public void onResponseFailed(String responseFailed) {
                interaction.hideLoading();
                interaction.showToast(responseFailed);
            }
        });
    }

    public void onFilterTouched(View view) {
        interaction.showLoading();

        teamService.findTeamsByCity(cityFilter.get(), new CallbackListener<List<TeamOutput>, String>() {
            @Override
            public void onResponseSuccess(List<TeamOutput> responseSuccess) {
                refreshList(responseSuccess);
                interaction.hideLoading();
                interaction.showToast("Teams filtered with success");
            }

            @Override
            public void onResponseFailed(String responseFailed) {
                interaction.hideLoading();
                interaction.showToast(responseFailed);
            }
        });
    }

    public void refreshList(List<TeamOutput> responseSuccess) {
        List<Team> teamsMapped = responseSuccess.stream().map(teamOutput ->
                new Team(teamOutput.getTeamname(), teamOutput.getCity())).collect(Collectors.toList());
        teams.clear();
        teams.addAll(teamsMapped);
    }

    public ObservableArrayList<Team> getTeams() {
        return teams;
    }

    public ObservableField<String> getCityFilter() {
        return cityFilter;
    }

    public void setInteraction(TeamActivityInteraction interaction) {
        this.interaction = interaction;
    }
}
