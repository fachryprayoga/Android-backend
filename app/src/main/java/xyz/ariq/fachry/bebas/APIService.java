package xyz.ariq.fachry.bebas;

import android.accessibilityservice.GestureDescription;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
/**
 * Created by user on 19/12/2017.
 */

public interface APIService {
    @FormUrlEncoded
    @POST("user/login")
    Call<Response>dologin (@Field("username") String username,@Field("password") String password);

}
