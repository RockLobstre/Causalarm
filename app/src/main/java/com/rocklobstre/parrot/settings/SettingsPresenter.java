package com.rocklobstre.parrot.settings;

import javax.inject.Inject;

/**
 * Created by Matin on 05/03/2017.
 */

public class SettingsPresenter implements SettingsContract.Presenter {
    private final SettingsContract.View view;

    @Inject
    public SettingsPresenter(SettingsContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void onBackButtonPress() {
        view.startAlarmListActivity();
    }
}
