package com.rocklobstre.parrot.alarmlist;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.rocklobstre.parrot.R;
import com.rocklobstre.parrot.util.ActivityUtils;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;

public class AlarmListActivity extends AppCompatActivity {
    private static final String FRAG_ALARM_LIST = "FRAG_ALARM_LIST";

    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_list);
        //Toolbar
        // toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);
        manager = getSupportFragmentManager();

        AlarmListFragment fragment = (AlarmListFragment) manager.findFragmentByTag(FRAG_ALARM_LIST);

        if (fragment == null) {
            fragment = AlarmListFragment.newInstance();
        }

        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                fragment,
                R.id.cont_alarm_list_fragment,
                FRAG_ALARM_LIST
        );

        new TedPermission(this)
                .setPermissionListener(
                        new PermissionListener() {
                            @Override
                            public void onPermissionGranted() {

                            }

                            @Override
                            public void onPermissionDenied(ArrayList<String> deniedPermissions) {

                            }
                        }
                )
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(
                        Manifest.permission.WAKE_LOCK,
                        Manifest.permission.VIBRATE
                )
                .check();
    }
    /**
     * Allows to get the intent to launch this activity from a notification
     * With a given preselected category name
     * @param context
     */
    public static Intent getIntentForNotification(Context context) {
        Intent intent = new Intent(context, AlarmListActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }
}
