package com.example.icoper.fsociety;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by icoper on 16.10.16.
 */

public class BluetoothReceiver extends BroadcastReceiver {
    private Intent bluetoothIntent;
    private Context bluetoothContext;

    @Override
    public void onReceive(Context context, Intent intent) {
        this.bluetoothContext = context;
        this.bluetoothIntent = intent;
        checkStatus();
    }

    private void checkStatus() {
        BluetoothAdapter bluetoothAdapter;
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter.isEnabled()) {
            MainActivity.setBtSt("ON");
            ModulsData.getInstance().addValue("BT", 1);
        } else {
            MainActivity.setBtSt("OFF");
            ModulsData.getInstance().addValue("BT", 0);
        }
    }
}
