package com.example.icoper.fsociety;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {


    static TextView btSt;
    static TextView gsmSt;
    static TextView wifiSt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifiSt = (TextView) findViewById(R.id.wifiStatus);
        btSt = (TextView)findViewById(R.id.bluetoothStatus);
        gsmSt = (TextView)findViewById(R.id.gsmStatus);

        ModulsData.getInstance().setGlobalContext(this);

    }

    public static void setWifiSt(String st) {
        wifiSt.setText(st);
    }

    public static void setBtSt(String st) {
        btSt.setText(st);
    }

    public static void setGsmSt(String st) {
        gsmSt.setText(st);
    }

}
