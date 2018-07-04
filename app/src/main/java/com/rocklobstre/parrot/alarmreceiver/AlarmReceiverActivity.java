package com.rocklobstre.parrot.alarmreceiver;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.rocklobstre.parrot.R;
import com.rocklobstre.parrot.util.ActivityUtils;

/**
 * This Activity is fired when an Alarm goes off. Once it is active, it handles the Alarm based on
 * the Alarm's configuration (such as Vibrate Only, etc.). It also allows the user to stop
 * an Alarm which is going off.
 * Created by Matin on 17/04/2016.
 */
public class AlarmReceiverActivity extends AppCompatActivity {

    private static final String ALARM_FRAGMENT = "ALARM_FRAGMENT";
    private static final String ALARM_ID = "ALARM_ID";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //apparently flags need to be set before calling setContentView
        //TODO figure out which of these is actually necessary lol.
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN |
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                        WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_FULLSCREEN |
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                        WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);

        setContentView(R.layout.activity_alarm_receiver);

        String reminderId = getIntent().getStringExtra(ALARM_ID);

        FragmentManager manager = this.getSupportFragmentManager();

        AlarmReceiverFragment fragment = (AlarmReceiverFragment) manager.findFragmentByTag(ALARM_FRAGMENT);

        if (fragment == null) {
            fragment = AlarmReceiverFragment.newInstance(reminderId);
        }

        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                fragment,
                R.id.root_alarm,
                ALARM_FRAGMENT
        );


    }
}
