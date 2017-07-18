package com.vsossella.mvvmapp.ui.team.interaction;

/**
 * Created by vsossella on 26/06/17.
 */

public interface TeamActivityInteraction {

    void showLoading();
    void hideLoading();
    void showToast(String toastMessage);

}
