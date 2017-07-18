package com.vsossella.mvvmapp.ui.team.view;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.vsossella.mvvmapp.MainApplication;
import com.vsossella.mvvmapp.R;
import com.vsossella.mvvmapp.databinding.TeamActivityBinding;
import com.vsossella.mvvmapp.ui.team.interaction.TeamActivityInteraction;
import com.vsossella.mvvmapp.ui.team.viewmodel.TeamViewModel;

import javax.inject.Inject;

/**
 * Created by vsossella on 26/06/17.
 */

public class TeamActivity extends AppCompatActivity implements TeamActivityInteraction {

    @Inject
    TeamViewModel teamViewModel;
    TeamActivityBinding binding;
    ProgressDialog progress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
        progress = new ProgressDialog(this);
        teamViewModel.setInteraction(this);

        binding = DataBindingUtil.setContentView(this, R.layout.team_activity);
        teamViewModel.loadTeamsFromAPI();
        binding.setViewModel(teamViewModel);
        setSupportActionBar(binding.toolbar);
    }

    private void injectDependencies() {
        ((MainApplication) getApplication()).getAppComponent().inject(this);
    }

    @Override
    public void showLoading() {
        progress.setMessage(getString(R.string.wait));
        progress.setCancelable(false);
        progress.show();
    }

    @Override
    public void hideLoading() {
        progress.dismiss();
    }

    @Override
    public void showToast(String toastMessage) {
        Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
    }
}
