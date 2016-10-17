package com.example.icoper.fsociety;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by icoper on 16.10.16.
 */

public class NotificationCenter extends Notification {


    private HashMap<String, Integer> modulStatusBase;
    private int activationModulsQuantity;


    public void getRulls(HashMap<String, Integer> map) {
        modulStatusBase = map;
        changePrametr();
    }

    public NotificationCenter() {

    }


    private void changePrametr() {

        // обнуляем счетчик
        activationModulsQuantity = 0;
        for (Map.Entry entry : modulStatusBase.entrySet()) {
            int temp = (int) entry.getValue();
            if (temp == 1) {
                activationModulsQuantity++;
            }
        }

        if (activationModulsQuantity > 3) {
            Log.d(" -----Moduls activate", " 3+");
        } else thatShow(activationModulsQuantity);

    }

    private void thatShow(int quantityOn) {
        switch (quantityOn) {
            case 1:
                showNotification("ББ подглядывает за тобой!");
                break;
            case 2:
                showNotification("ББ присматривает за тобой!");
                break;
            case 3:
                showNotification("ББ следит за тобой!");
                break;
        }
    }

    private void showNotification(String str) {

        NotificationManager nm;
        NotificationCompat.Builder nBuilder;
        nBuilder = new NotificationCompat.Builder(ModulsData.getInstance().getGlobalContext());
        nBuilder.setContentTitle("Fsociety");
        nBuilder.setContentText(str);
        nBuilder.setSmallIcon(R.drawable.ic_action_name);

        Notification notification = nBuilder.build();
        nm = (NotificationManager) ModulsData.getInstance().getGlobalContext().getSystemService(Context.NOTIFICATION_SERVICE);

        nm.notify(1, notification);
    }

}
