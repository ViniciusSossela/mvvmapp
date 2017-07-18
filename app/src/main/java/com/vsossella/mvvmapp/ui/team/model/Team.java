package com.vsossella.mvvmapp.ui.team.model;

/**
 * Created by vsossella on 26/06/17.
 */

public class Team {

    public String teamName;
    public String city;

    public Team(String teamName, String city) {
        this.teamName = teamName;
        this.city = city;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
