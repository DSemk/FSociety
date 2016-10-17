package com.example.icoper.fsociety;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by icoper on 17.10.16.
 */
public class ModulsData {
    private Context globalContext;
    private static NotificationCenter notificationCenter = new NotificationCenter();
    private static ModulsData ourInstance = new ModulsData();

    private HashMap<String,Integer> modulStatusBase = new HashMap<>();

    public Context getGlobalContext(){
        return globalContext;
    }

    public void setGlobalContext(Context globalContext) {
        this.globalContext = globalContext;
    }

    private ModulsData() {
    }

    public void addValue(String key, int value){
        modulStatusBase.put(key,value);
        notificationCenter.getRulls(modulStatusBase);
    }

    public HashMap<String,Integer> getValue(){
        return modulStatusBase;
    }

    public static ModulsData getInstance() {
        return ourInstance;
    }


}
