package com.vsossella.mvvmapp;

import com.vsossella.mvvmapp.api.CallbackListener;
import com.vsossella.mvvmapp.api.entity.team.TeamOutput;
import com.vsossella.mvvmapp.service.team.TeamService;
import com.vsossella.mvvmapp.ui.team.interaction.TeamActivityInteraction;
import com.vsossella.mvvmapp.ui.team.viewmodel.TeamViewModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

/**
 * Created by vsossella on 18/07/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class TeamViewModelTest {

    TeamViewModel teamViewModel;

    @Mock
    TeamService teamServices;

    @Mock
    TeamActivityInteraction interaction;

    @Captor
    private ArgumentCaptor<CallbackListener<List<TeamOutput>, String>> cb;

    @Test
    public void loadTeamsFromAPI_Success_Behaves_as_Expected() {
        teamViewModel = new TeamViewModel(teamServices);
        teamViewModel.setInteraction(interaction);

        teamViewModel.loadTeamsFromAPI();
        verify(teamServices).findAllTeams(cb.capture());


        List<TeamOutput> responseSuccess = new ArrayList<>();
        TeamOutput team = new TeamOutput();
        team.setCity("dsadas");
        team.setTeamname("name");
        responseSuccess.add(team);
        cb.getValue().onResponseSuccess(responseSuccess);

        verify(interaction).showToast("Teams loaded with success");
        verify(interaction).hideLoading();


    }

    @Test
    public void loadTeamsFromAPI_Fail_Behaves_as_Expected() {
        teamViewModel = new TeamViewModel(teamServices);
        teamViewModel.setInteraction(interaction);

        teamViewModel.loadTeamsFromAPI();
        verify(teamServices).findAllTeams(cb.capture());

        cb.getValue().onResponseFailed("fail");

        verify(interaction).hideLoading();
        verify(interaction).showToast("fail");

    }


    @Captor
    ArgumentCaptor<CallbackListener<List<TeamOutput>, String>> findTeamsByCityCaptor;

    @Test
    public void findTeamsByCity_Fail_Behaves_as_Expected() {
        teamViewModel = new TeamViewModel(teamServices);
        teamViewModel.setInteraction(interaction);

        teamViewModel.onFilterTouched(null);
        verify(teamServices).findTeamsByCity(anyString(), findTeamsByCityCaptor.capture());

        findTeamsByCityCaptor.getValue().onResponseFailed("fail");

        verify(interaction).hideLoading();
        verify(interaction).showToast("fail");

    }

    @Test
    public void findTeamsByCity_Success_Behaves_as_Expected() {
        teamViewModel = new TeamViewModel(teamServices);
        teamViewModel.setInteraction(interaction);

        teamViewModel.onFilterTouched(null);
        verify(teamServices).findTeamsByCity(anyString(), findTeamsByCityCaptor.capture());

        List<TeamOutput> responseSuccess = new ArrayList<>();
        TeamOutput team = new TeamOutput();
        team.setCity("dsadas");
        team.setTeamname("name");
        responseSuccess.add(team);
        findTeamsByCityCaptor.getValue().onResponseSuccess(responseSuccess);

        verify(interaction).hideLoading();
        verify(interaction).showToast("Teams filtered with success");

    }



}
