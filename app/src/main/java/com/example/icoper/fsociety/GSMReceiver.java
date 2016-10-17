package com.example.icoper.fsociety;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.audiofx.BassBoost;
import android.provider.Settings;

/**
 * Created by icoper on 16.10.16.
 */

public class GSMReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        checkStatus();
    }

    private void checkStatus() {
        // получаем true или false в зависимости от состояние модуля
        boolean isEnabled = Settings.System.getInt(
                ModulsData.getInstance().getGlobalContext().getContentResolver(),
                Settings.System.AIRPLANE_MODE_ON, 0) == 1;

        if (!isEnabled) {
            MainActivity.setGsmSt("ON");
            ModulsData.getInstance().addValue("gsm", 1);
        } else {
            MainActivity.setGsmSt("OFF");
            ModulsData.getInstance().addValue("gsm", 0);
        }
    }
}
