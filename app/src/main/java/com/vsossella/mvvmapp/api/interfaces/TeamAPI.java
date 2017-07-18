package com.vsossella.mvvmapp.api.interfaces;

import com.vsossella.mvvmapp.api.entity.team.TeamOutput;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by vsossella on 26/06/17.
 */

public interface TeamAPI {

    @GET("teams")
    Call<List<TeamOutput>> findAllTeams();

}
