package psl.np.common.restClient;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.util.concurrent.TimeUnit;

public class ClientHelper {

    public static final int DEFAULT_TIMEOUT = 60;

    public static  <T> T buildClient(Class<T> tClass, String base, Interceptor... interceptors) {
        return buildClient(tClass, base, DEFAULT_TIMEOUT, interceptors);
    }

    public static <T> T buildClient(Class<T> tClass, String base, int timeout,
            Interceptor... interceptors) {
        Retrofit retrofit = buildRetrofit(base, timeout, interceptors);
        return retrofit.create(tClass);
    }

    static Retrofit buildRetrofit(String base, Interceptor... interceptors) {
        return buildRetrofit(base, DEFAULT_TIMEOUT, interceptors);
    }

    static Retrofit buildRetrofit(String base, int timeout, Interceptor... interceptors) {
        OkHttpClient client = buildOkClient(timeout, interceptors);
        return new Retrofit.Builder()
                .baseUrl(base)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public static OkHttpClient buildOkClient(Interceptor... interceptors) {
        return buildOkClient(DEFAULT_TIMEOUT, interceptors);
    }

    static OkHttpClient buildOkClient(int timeOut, Interceptor... interceptors) {
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
