package com.qamber.carpiker.Model;

import android.content.Context;

/**
 * Created by MAHAR on 30-Dec-17.
 */

public class Modelcountry {

    Context context;
    String countryname,countryflag;

    public Modelcountry(Context context, String countryname, String countryflag) {
        this.context = context;
        this.countryname = countryname;
        this.countryflag = countryflag;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getCountryflag() {
        return countryflag;
    }

    public void setCountryflag(String countryflag) {
        this.countryflag = countryflag;
    }
}
