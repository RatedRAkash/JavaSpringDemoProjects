package com.tutorial.akash_retrofit_client_spring_boot.RestClientAdvanceMechanism;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.util.concurrent.TimeUnit;

public class ClientHelper {
    public static final int DEFAULT_TIMEOUT = 60;
    public static Retrofit retrofit;

    //TODO ---> ApiError er jonno "responseBodyConverter" ei Method lagbe... jeita Retrofit class er Object ee ase
    public static Retrofit getRetrofitInstance() {
        if (retrofit != null) {
            return retrofit;
        } else {
            return null;
        }
    }

    public static <T> T buildRetrofitClient(Class<T> tClass, String baseUrl, int timeout,
                                            Interceptor... interceptors) {
        retrofit = buildRetrofit(baseUrl, timeout, interceptors);


        //TODO: this here means, amra "tService" er jei INTERFACE Declare korsi... shei INTERFACE er CONCRETE CLASS(jaar moddhe Method Overrided ase) sheita return korbe
        return retrofit.create(tClass); //eitar INTERFACE argument hisave ney & CONCRETE CLASS return kore jaar moddhe implementation likha takhe
    }

    static Retrofit buildRetrofit(String baseUrl, int timeout, Interceptor... interceptors) {
        OkHttpClient okHttpClient = buildOkHTTPClient(timeout, interceptors);
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    static OkHttpClient buildOkHTTPClient(int timeOut, Interceptor... interceptors) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(timeOut, TimeUnit.SECONDS)
                .writeTimeout(timeOut, TimeUnit.SECONDS)
                .readTimeout(timeOut, TimeUnit.SECONDS);
        if (interceptors != null && interceptors.length > 0) {
            for (Interceptor interceptor : interceptors) {
                builder.addInterceptor(interceptor);
            }
        }
        return builder.build();
    }
}
