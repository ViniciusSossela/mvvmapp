package com.vsossella.mvvmapp.api.entity.team;

import com.google.gson.annotations.SerializedName;

public class TeamOutput{

	@SerializedName("city")
	private String city;

	@SerializedName("teamname")
	private String teamname;

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setTeamname(String teamname){
		this.teamname = teamname;
	}

	public String getTeamname(){
		return teamname;
	}

	@Override
 	public String toString(){
		return 
			"TeamOutput{" + 
			"city = '" + city + '\'' + 
			",teamname = '" + teamname + '\'' + 
			"}";
		}
}