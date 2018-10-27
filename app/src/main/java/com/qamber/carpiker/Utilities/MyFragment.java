package com.qamber.carpiker.Utilities;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;


/**
 * Created by PC-07 on 3/21/2017.
 */

public abstract class MyFragment extends Fragment {
    public Typeface standardRoman;
    public Typeface standardMedium;
    public int SELECT_IMAGE = 111;
    public String CONNECTION_ERROR = "Internet Connection Error";

    public static boolean askPIN = false;
    ProgressDialog progressDialog;

    public SharedPreferences sharedPreferences;


    @Nullable

    public abstract void onBackPressed();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

//        standardMedium           = Typeface.createFromAsset(getActivity().getAssets(), "fonts/HelveticaNeueLTStd-Md.otf");
 //       standardRoman            = Typeface.createFromAsset(getActivity().getAssets(), "fonts/HelveticaNeueLTStd-Roman.otf");


        super.onViewCreated(view, savedInstanceState);
    }

    public void logIfDebug(String tag, String message){
        if (AppConstants.debug)
            Log.e(tag,message);
    }

    @SuppressLint("NewApi")
    public boolean isEmail(String email) {

        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }
    @SuppressLint("NewApi")
    public boolean isPassword(String password) {

        if (password.length()>=6)
            return true;
        else
            return false;
    }

    public void setAskForPIN(boolean should){
        askPIN = should;
    }
    public boolean shouldAskForPIN(){

        return askPIN;
    }


    public Bitmap base64ToBitmap(String b64) {
        byte[] imageAsBytes = Base64.decode(b64.getBytes(), Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length);
    }

    protected void showDialog(Context context){
        if (progressDialog==null){
            progressDialog = new ProgressDialog(context);
            progressDialog.setMessage("Please Wait");
            progressDialog.setCanceledOnTouchOutside(false);
        }
        progressDialog.show();
    }
    protected void showDialog(Context context, String message){
        if (progressDialog==null){
            progressDialog = new ProgressDialog(context);
            progressDialog.setMessage(message);
            progressDialog.setCanceledOnTouchOutside(false);
        }else{
            progressDialog.setMessage(message);
            progressDialog.setCanceledOnTouchOutside(false);
        }
        progressDialog.show();
    }

    protected void hideProgressDialog(){
        if (progressDialog!=null && progressDialog.isShowing()){
            progressDialog.hide();
        }
    }
    protected void showToast(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public String getPath(Context context, Uri uri) {
        Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        String document_id = cursor.getString(0);
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
        cursor.close();

        cursor = context.getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null);
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
        cursor.close();
        logIfDebug("File Path",path);
        return path;
    }

    public void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_IMAGE);
    }

    public void fixWidthOfEditText(EditText editText){

        editText.setMaxWidth(editText.getWidth());
    }

    public void logout(Context context){
        /*Intent intent = new Intent(context,Login.class);
        new SessionManager(context,"");
        intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);*/

    }
}
