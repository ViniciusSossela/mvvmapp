package com.vsossella.mvvmapp;

import com.vsossella.mvvmapp.api.entity.team.TeamOutput;
import com.vsossella.mvvmapp.service.team.TeamService;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

/**
 * Created by vsossella on 27/06/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class TeamTest {

    @InjectMocks
    TeamService teamService;

    @Test
    public void filter_team_by_city_behave_as_expected() {
        List<TeamOutput> teams = new ArrayList<>();
        TeamOutput teamPorto = new TeamOutput();
        teamPorto.setCity("Porto");

        TeamOutput teamSP = new TeamOutput();
        teamSP.setCity("São Paulo");

        teams.add(teamPorto);
        teams.add(teamSP);

        List<TeamOutput> teamsFiltered = teamService.filterByCity("Porto", teams);

        Assert.assertTrue(teamsFiltered.size() == 1);
    }




}
