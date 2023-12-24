package com.tutorial.akash_retrofit_client_spring_boot.FutureStudioTutorial;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.function.Function;

public class ServiceGenerator {
    private static final String BASE_URL = "http://localhost:8080";

    private static Retrofit.Builder builder = new Retrofit.Builder()
                                                    .baseUrl(BASE_URL)
                                                    .addConverterFactory(GsonConverterFactory.create());
    private static Retrofit retrofitClient = builder.build();

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();


    public static <TService> TService createService(Class<TService> serviceClass){
        return retrofitClient.create(serviceClass);
    }

    public static <TDto, TService> TDto callApi(Class<TService> serviceClass, Function<TService, Call<TDto>> action) throws IOException {
        TService tServiceClassObj = createService(serviceClass);
        //TODO:
        // Call<TDto>> ---> action TService Class er Vitor er jei Function Call kore amra Endpoint ee Hit kobro, shei Function ta ke Call korar jonno ei Parameter lagbe
        Response<TDto> mainResponseObj= action.apply(tServiceClassObj).execute();
        return mainResponseObj.body();
    }
}
