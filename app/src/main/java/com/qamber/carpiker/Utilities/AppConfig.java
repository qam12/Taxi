package com.qamber.carpiker.Utilities;


import android.util.Log;

/**
 * Created by PC-07 on 2/15/2017.
 */

public class AppConfig {
    static boolean DEBUG = true;
    public static String NO_CONNECTION_TEXT     = "Check your Internet Connection";
    public static String JSON_ERROR_TEXT        = "Invalid Response";
    public static String API_KEY = "AIzaSyDswY8wrbUBWEmTC-P8reRDncOTTXHyOHg";
    public static String PACKAGE_NAME = "drive_a_go.appxone.com.driveago.";

    public static void logIfDebug(String tag , String message){
        if (DEBUG){
            Log.e(tag,message);
        }
    }



}
