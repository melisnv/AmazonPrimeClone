package com.melisnurverir.amazonprimeclone.retrofit;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    // private static final String BASE_URL = "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/api/";
    //private static final String BASE_URL = "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/";
    private static final String BASE_URL = "https://prime-clone-movie-api.herokuapp.com/";

    public static ApiInterface getRetrofitClient(){

        Retrofit.Builder builder = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .baseUrl(BASE_URL);

        return builder.build().create(ApiInterface.class);
    }
}
