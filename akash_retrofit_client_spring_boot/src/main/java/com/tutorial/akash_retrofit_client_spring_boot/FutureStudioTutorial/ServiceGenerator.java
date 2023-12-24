package com.tutorial.akash_retrofit_client_spring_boot.FutureStudioTutorial;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static final String BASE_URL = "http://localhost:8080";

    private static Retrofit.Builder builder = new Retrofit.Builder()
                                                    .baseUrl(BASE_URL)
                                                    .addConverterFactory(GsonConverterFactory.create());
    private static Retrofit retrofitClient = builder.build();

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();


    public static <S> S createService(Class<S> serviceClass){
        return retrofitClient.create(serviceClass);
    }
}
