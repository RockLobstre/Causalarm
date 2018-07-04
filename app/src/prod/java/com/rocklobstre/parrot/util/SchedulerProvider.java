package com.rocklobstre.parrot.util;

import com.rocklobstre.parrot.util.BaseSchedulerProvider;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * SchedulerProvider for use during tests. Supplies immediate Schedulers which can be run on the JVM without issue.
 * Created by Matin on 10/04/2017.
 */

public class SchedulerProvider implements BaseSchedulerProvider {

    public SchedulerProvider() {
    }

    @Override
    public Scheduler computation() {
        return Schedulers.computation();
    }

    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
