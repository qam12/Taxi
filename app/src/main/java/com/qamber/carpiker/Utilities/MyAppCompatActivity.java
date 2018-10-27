package com.qamber.carpiker.Utilities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
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
import android.support.design.BuildConfig;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.util.Base64;
import android.util.Log;
import android.util.Patterns;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;


/**
 * Created by PC-07 on 2/21/2017.
 */

public abstract class MyAppCompatActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    public String CONNECTION_ERROR = "Internet Connection Error";
    public Typeface standardRoman;
    public Typeface standardMedium;
    public Typeface standardRomanMediumCn;
    public SharedPreferences sharedPreferences;//
    public static boolean askPIN = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        standardMedium           = Typeface.createFromAsset(getAssets(), "fonts/HelveticaNeueLTStd-Md.otf");
     //   standardRoman            = Typeface.createFromAsset(getAssets(), "fonts/HelveticaNeueLTStd-Roman.otf");
//        standardRomanMediumCn   = Typeface.createFromAsset(getAssets(), "fonts/HelveticaNeueLTStd-MdCn.otf");*/
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    }

    public void logIfDebug(String tag, String message){
        if (BuildConfig.DEBUG)
            Log.e(tag,message);
    }

    @SuppressLint("NewApi")
    public boolean isEmail(String email) {

        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }
    @SuppressLint("NewApi")
    public boolean isEmail(EditText email) {

        Pattern pattern = Patterns.EMAIL_ADDRESS;
        if (pattern.matcher(email.getText().toString()).matches())
        return true;
        else{
            email.setError("Invalid Email");
        }
        return false;
    }
    @SuppressLint("NewApi")
    public boolean isPassword(String password) {

        if (password.length()>=6)
            return true;
        else
            return false;
    }
    @SuppressLint("NewApi")
    public boolean isPassword(EditText password) {

        if (password.getText().toString().length()>=6)
            return true;
        else {
            password.setError("Insufficient Length");
            return false;
        }
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

    protected String getFromPreferences(Context context, String key){
        return PreferenceManager.getDefaultSharedPreferences(context).getString(key,"");
    }

    protected boolean isLoggedIn(Context context){
        if(getFromPreferences(context, AppConstants.KEY_AUTH_TOKEN).equals("")){
            return false;
        }else{
            return true;
        }
    }

    public String getPath(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        String document_id = cursor.getString(0);
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
        cursor.close();

        cursor = getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null);
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
        cursor.close();
        logIfDebug("File Path",path);
        return path;
    }

    public void logout(Context context){
//        Intent intent = new Intent(context,Welcome.class);
//        new SessionManager(context,"");
//        intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
//        startActivity(intent);

    }
    /*public Bitmap getMarkerBitmapFromView(@DrawableRes int resId, Context context) {

        View customMarkerView = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.view_custom_marker, null);
        ImageView markerImageView = (ImageView) customMarkerView.findViewById(R.id.profile_image);
        markerImageView.setImageResource(resId);
        customMarkerView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        customMarkerView.layout(0, 0, customMarkerView.getMeasuredWidth(), customMarkerView.getMeasuredHeight());
        customMarkerView.buildDrawingCache();
        Bitmap returnedBitmap = Bitmap.createBitmap(customMarkerView.getMeasuredWidth(), customMarkerView.getMeasuredHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        canvas.drawColor(Color.WHITE, PorterDuff.Mode.SRC_IN);
        Drawable drawable = customMarkerView.getBackground();
        if (drawable != null)
            drawable.draw(canvas);
        customMarkerView.draw(canvas);
        return returnedBitmap;
    }*/
    public Double meterToMiles(float meter){
        return meter * 0.00062137;
    }
    public void fixEditTextWidth(EditText editText){
        editText.setMaxWidth(editText.getWidth());
    }

    public static void showSnackBar(Activity activity, String message) {
        Snackbar snackbar = Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT);
        //snackbar.getView().setBackgroundColor(
        // getResources().getColor(R.color.colorGreen));
        View snackbarView = snackbar.getView();
        Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
      //  layout.setGravity(Gravity.CENTER);
        TextView mTextView = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
        mTextView.setGravity(Gravity.CENTER_HORIZONTAL);
        mTextView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        snackbar.show();
    }
    protected View initializeViewById(Activity activity, int id){
        return activity.findViewById(id);
    }
    protected TextView tvInitializer(Activity activity, int id){
        return (TextView)activity.findViewById(id);
    }
    protected EditText etInitializer(Activity activity, int id){
        return (EditText) activity.findViewById(id);
    }
    protected ListView lvInitializer(Activity activity, int id){
        return (ListView) activity.findViewById(id);
    }

    protected SwitchCompat swCompatInitializer(Activity activity, int id){
        return (SwitchCompat) activity.findViewById(id);
    }

    protected RadioButton rbInitializer(Activity activity, int id){
        return (RadioButton) activity.findViewById(id);
    }
    protected ImageView ivInitializer(Activity activity, int id){
        return (ImageView) activity.findViewById(id);
    }
    protected Button btInitializer(Activity activity, int id){
        return (Button) activity.findViewById(id);
    }
    protected String getStringFromIntent(Bundle bundle, String key){
        if(bundle!=null){
            return bundle.getString(key,"");
        }
        else return "";
    }

}
