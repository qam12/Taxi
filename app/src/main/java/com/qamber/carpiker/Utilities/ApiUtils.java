package com.qamber.carpiker.Utilities;

/**
 * Created by Appxone on 7/6/2017.
 */
public class ApiUtils {

    public static final String BASE_URL = "http://softwares-tools.com/projects/plug/webservices";

    public static SOService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
}