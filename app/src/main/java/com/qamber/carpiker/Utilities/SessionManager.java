package com.qamber.carpiker.Utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;


/**
 * Created by ATC-7 on 8/16/2016.
 */
public class SessionManager {
    private static String TAG = SessionManager.class.getSimpleName();

    // Shared Preferences
    SharedPreferences pref;

    SharedPreferences.Editor editor;
    Context _context;

    // Shared pref mode 
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    public static final String PREF_NAME = "MyPrefs";
    // private static final String EMAIL="s";
    //private static final String PASSWORD="s";
    private static final String SESSION_ID = "";
    private static String USERID = "";
    private static String KEY_IS_LOGGEDIN = "isLoggedIn";


  /*  public SessionManager(Context context, String dviceID) {
        this._context = context;
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        // pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        editor.putString("DEVICEID", dviceID);
        AppConfig.logIfDebug("COMMITING ",  dviceID);
        editor.commit();

    }*/
  /*  public SessionManager(Context context, Boolean b, String sid) {
        this._context = context;
        pref = PreferenceManager.getDefaultSharedPreferences(this._context);
        // pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();

        editor.putBoolean("LOGGEDIN", b);
        editor.putBoolean("GOOGLE", b);
        editor.putString("SESSIONID", sid);
        AppConfig.logIfDebug("COMMIT", b  + sid);
        editor.commit();
    }*/



    public SessionManager(Context context, String e, String p, Boolean b, String uid, String sid) {
        this._context = context;
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        // pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        editor.putString("EMAIL", e);
        editor.putString("PASSWORD", p);
        editor.putBoolean("LOGGEDIN", b);
        editor.putString("USERID", uid);
        editor.putString("SESSIONID", sid);
        AppConfig.logIfDebug("COMMIT", e + p + b + uid + sid);
        editor.commit();
    }

// Session for Application Login
    public SessionManager(Context context, String e, String uid, String sid) {
        this._context = context;
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        // pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        editor.putString("EMAIL", e);
        editor.putString("USERID", uid);
        editor.putString("AUTH_TOKEN", sid);
        AppConfig.logIfDebug("COMMIT", e +" "+ uid+" " + sid);
        editor.commit();
    }

    public SessionManager(Context context, String e, String uid) {
        this._context = context;
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        // pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        editor.putString("EMAIL", e);
        editor.putString("USERID", uid);
    /*    editor.putString("AUTH_TOKEN", sid);
        AppConfig.logIfDebug("COMMIT", e +" "+ uid+" " + sid);*/
        editor.commit();
    }
    public SessionManager(Context context, String languages,String e,int s) {
        this._context = context;
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        // pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        editor.putString("languages", languages);

    /*    editor.putString("AUTH_TOKEN", sid);
        AppConfig.logIfDebug("COMMIT", e +" "+ uid+" " + sid);*/
        editor.commit();
    }
    // Session for GOOGLE Login
/*    public SessionManager(Context context, String fName, String lName, String email, String pic, String phone) {
        this._context = context;
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        // pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        editor.putString("FNAME", fName);
        editor.putString("LNAME",lName);
        editor.putString("AVATAR", pic);
        editor.putString("NUMBER", phone);
        AppConfig.logIfDebug("COMMITING",  " "+ fName +" "+ lName);
        editor.commit();
    }*/
    public SessionManager(Context context) {
        this._context = context;
        pref = PreferenceManager.getDefaultSharedPreferences(context);

    }
/*    public SessionManager(Context context, String email, String password, String token, String phoneKey) {
        this._context = context;
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        editor = pref.edit();
        editor.putString("EMAIL",email);
        editor.putString("PASSWORD",password);
        editor.putString("AUTH_TOKEN",token);
        editor.putString("PHONE_KEY",phoneKey);
        editor.commit();
        AppConfig.logIfDebug("Committing",email + " "+ password +" " + token);

    }*/
    public SessionManager(Context context, String token) {
        this._context = context;
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        editor = pref.edit();
        editor.putString("AUTH_TOKEN",token);
        editor.commit();
        AppConfig.logIfDebug("Committing",token);

    }
    public SessionManager(Context context, Boolean remember) {
        this._context = context;
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        editor = pref.edit();
        editor.putBoolean("REMEMBER",remember);
        editor.commit();

    }

    public SessionManager(Context context, String email, String token, String password, String image,
                          String name, String mobile, String city, String theme, String dob, String location) {
        this._context = context;
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        editor = pref.edit();
        editor.putString("EMAIL",email);
        editor.putString("AUTH_TOKEN",token);
        editor.putString("PASSWORD",password);
        editor.putString("IMAGE",image);
        editor.putString("NAME",name);
        editor.putString("MOBILE",mobile);
        editor.putString("CITY",city);
        editor.putString("THEME",theme);
        editor.putString("DOB",dob);
        editor.putString("LOC",location);
        editor.commit();
        AppConfig.logIfDebug("Committing",email + " " +" " );

    }
    public SessionManager(Context context, String email, String image,
                          String name, String mobile, String city, String theme, String bio, String dob) {
        this._context = context;
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        editor = pref.edit();
        editor.putString("EMAIL",email);
        editor.putString("IMAGE",image);
        editor.putString("NAME",name);
        editor.putString("MOBILE",mobile);
        editor.putString("CITY",city);
        editor.putString("THEME",theme);
        editor.putString("BIO",bio);//,
        editor.putString("DOB",dob);
        editor.commit();
        AppConfig.logIfDebug("Committing",email + " " +" " );

    }

    public SessionManager(Context context, Boolean completed, String lastScreen) {
        this._context = context;
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        editor = pref.edit();
        editor.putBoolean("COMPLETED",completed);
        editor.putString("LAST_SCREEN",lastScreen);
        editor.commit();

    }
    /*public SessionManager(String contact, Context context, Boolean isVerified) {
        this._context = context;
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        editor = pref.edit();
        editor.putBoolean("VERIFIED",isVerified);
        editor.commit();

    }
*/

    public void setLogin(boolean isLoggedIn) {

        editor.putBoolean(KEY_IS_LOGGEDIN, isLoggedIn);

        // commit changes
        editor.commit();

        Log.d(TAG, "User getRoutes session modified!");
    }

    public boolean isLoggedIn() {
        AppConfig.logIfDebug("isLoggedIn", pref.getBoolean(KEY_IS_LOGGEDIN, false) + " ");
        return pref.getBoolean(KEY_IS_LOGGEDIN, false);
    }


}
