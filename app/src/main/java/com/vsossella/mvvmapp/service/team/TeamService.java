package com.vsossella.mvvmapp.service.team;

import com.vsossella.mvvmapp.api.CallbackListener;
import com.vsossella.mvvmapp.api.entity.team.TeamOutput;
import com.vsossella.mvvmapp.api.interfaces.TeamAPI;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by vsossella on 28/06/17.
 */

@Singleton
public class TeamService {

    Retrofit retrofit;

    @Inject
    public TeamService(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public void findAllTeams(CallbackListener<List<TeamOutput>, String> callbackListener) {

        retrofit.create(TeamAPI.class).findAllTeams().enqueue(new Callback<List<TeamOutput>>() {
            @Override
            public void onResponse(Call<List<TeamOutput>> call, Response<List<TeamOutput>> response) {
                if (response.isSuccessful())
                    callbackListener.onResponseSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<TeamOutput>> call, Throwable t) {
                callbackListener.onResponseFailed(t.getMessage());
            }
        });
    }

    public void findTeamsByCity(String city, CallbackListener<List<TeamOutput>, String> callbackListener) {

        retrofit.create(TeamAPI.class).findAllTeams().enqueue(new Callback<List<TeamOutput>>() {
            @Override
            public void onResponse(Call<List<TeamOutput>> call, Response<List<TeamOutput>> response) {
                if (response.isSuccessful()) {
                    List<TeamOutput> teamsFilteredByCity = filterByCity(city, response.body());
                    callbackListener.onResponseSuccess(teamsFilteredByCity);
                }
            }

            @Override
            public void onFailure(Call<List<TeamOutput>> call, Throwable t) {
                callbackListener.onResponseFailed(t.getMessage());
            }
        });
    }

    public List<TeamOutput> filterByCity(String city, List<TeamOutput> list) {
        if (city.isEmpty())
            return list;
        else
            return list.stream().filter(f -> f.getCity().equals(city)).collect(Collectors.toList());
    }
}