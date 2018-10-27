package com.qamber.carpiker.Utilities;

/**
 * Created by Appxone on 7/6/2017.
 */



import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface SOService {

/*    @GET("signin.php")
    Call<ModelUserMain> login(@Query("email") String email, @Query("password") String password);


    @GET("forgot_password.php")
    Call<ModelForgotPassword> Restepassword(@Query("email") String email);

    @GET("topby_genre.php")
    Call<ModelAllTopSongs> getAllsongs(@Query("user_id") String user_id, @Query("session_id") String session_id, @Query("offset") String offset, @Query("limit") String limit, @Query("genre") String genre);

    @GET("topartists.php")
    Call<ModelArtistWeb> getTopArtist(@Query("user_id") String user_id, @Query("session_id") String session_id, @Query("offset") String offset, @Query("limit") String limit);

    @GET("addsong_fav.php")
    Call<ModelFavorites> Favroites(@Query("user_id") String user_id, @Query("session_id") String session_id, @Query("song_id") String song_id);



    @GET("search_artist.php")
    Call<ModelSearchResult> Search(@Query("user_id") String user_id, @Query("session_id") String session_id, @Query("offset") String offset, @Query("limit") String limit, @Query("search_term") String search_term);

    @Multipart
    @POST("signup.php")
    Call<ModelSignUp> Signup(@Query("fname") String Firstname, @Query("lname") String Lastname, @Query("email") String email, @Query("pword") String password, @Query("phone") String phone, @Field("dis_pic") Map<String, RequestBody> name);
   @Multipart*/

/*
   @POST("signup.php")
   Call<ModelSignUp> uploadImage(@Query("fname") String Firstname, @Query("lname") String Lastname, @Query("email") String email, @Query("password") String password, @Query("deviceid") String deviceid, @Query("devicetype") String devicetype, @Query("role") String role);
   @Multipart
   @POST("signup.php")
   Call<ModelSignUp> uploadImage(@Query("fname") String Firstname, @Query("lname") String Lastname, @Query("email") String email, @Query("password") String password, @Query("deviceid") String deviceid, @Query("devicetype") String devicetype, @Query("role") String role, @Part MultipartBody.Part file);

*/


}