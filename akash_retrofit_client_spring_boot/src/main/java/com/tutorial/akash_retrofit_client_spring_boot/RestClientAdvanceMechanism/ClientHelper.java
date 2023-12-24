package com.tutorial.akash_retrofit_client_spring_boot.RestClientAdvanceMechanism;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.util.concurrent.TimeUnit;

public class ClientHelper {
    public static final int DEFAULT_TIMEOUT = 60;

    public static <T> T buildRetrofitClient(Class<T> tClass, String base, int timeout,
                                            Interceptor... interceptors) {
        Retrofit retrofit = buildRetrofit(base, timeout, interceptors);

        // jei "Class" pathano huise... shei Class er against ee Retrofit Client Create kore, shei Class ta kei Return kore dilam
        return retrofit.create(tClass);
    }

    static Retrofit buildRetrofit(String base, int timeout, Interceptor... interceptors) {
        OkHttpClient client = buildOkHTTPClient(timeout, interceptors);
        return new Retrofit.Builder()
                .baseUrl(base)
                .client(client)
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
