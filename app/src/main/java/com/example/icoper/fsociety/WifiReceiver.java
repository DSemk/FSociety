package com.example.icoper.fsociety;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.support.v7.app.NotificationCompat;

/**
 * Created by icoper on 15.10.16.
 */

public class WifiReceiver extends BroadcastReceiver {

    private Context wifiContext;
    private Intent wifiIntent;

    private NotificationManager nm;
    private NotificationCompat.Builder nBuilder;

    @Override
    public void onReceive(Context context, Intent intent) {
        this.wifiContext = context;
        this.wifiIntent = intent;
        checkStatus();
    }

    private void checkStatus(){
        int state = wifiIntent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, -1);
        switch (state) {
            case WifiManager.WIFI_STATE_DISABLED:
                MainActivity.setWifiSt("OFF");
                ModulsData.getInstance().addValue("wifi",0);
                break;
            case WifiManager.WIFI_STATE_ENABLED:
                MainActivity.setWifiSt("ON");
                ModulsData.getInstance().addValue("wifi",1);
                break;
            case WifiManager.WIFI_STATE_DISABLING:
                MainActivity.setWifiSt("OFF");
                ModulsData.getInstance().addValue("wifi",0);
                break;
            case WifiManager.WIFI_STATE_ENABLING:
                MainActivity.setWifiSt("ON");
                ModulsData.getInstance().addValue("wifi",1);
                break;
        }
    }

}
