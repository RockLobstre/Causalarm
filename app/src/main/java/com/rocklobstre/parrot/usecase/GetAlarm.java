package com.rocklobstre.parrot.usecase;

import com.rocklobstre.parrot.data.local.AlarmSource;
import com.rocklobstre.parrot.data.viewmodel.Alarm;

import io.reactivex.Flowable;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Retrieve a specific Alarm from the Database, according to a reminderId which is passed in to
 * this Use Case.
 * - If a Alarm is found, return it to the Presenter.
 * - If no Alarm is found, throw NoReminderFoundException
 * Created by Matin on 5/23/2017.
 */

public class GetAlarm implements UseCase<Alarm, String> {

    /**
     *Alarm Service is a Facade/Repository Pattern which Abstracts Realm from the rest of my the
     App
     */
    private final AlarmSource alarmSource;

    public GetAlarm(AlarmSource alarmSource) {
        this.alarmSource = alarmSource;
    }

    @Override
    public Flowable<Alarm> runUseCase(String... params) {
        return alarmSource.getAlarmsById(params[0]);
    }

}
