package com.rocklobstre.parrot.settings;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Matin on 16/03/2017.
 */

@Module
public class SettingsPresenterModule {
    //List what you would normally pass in as arguments to a Presenter's constructor
    private final SettingsContract.View view;

    public SettingsPresenterModule(SettingsContract.View view) {
        this.view = view;
    }

    @Provides
    SettingsContract.View provideSettingsView(){
        return view;
    }
}
