package com.example.mobile2;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RegisterAPI {
    @GET("get_mahasiswa.php")
    Call<Value> view();

    @FormUrlEncoded
    @POST("get_login.php")
    Call<ResponseBody> login(@Field("username") String username,
                             @Field("password") String password);

    @GET("get_products.php")
    Call<List<Product>> getProducts();

}
