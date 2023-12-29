package com.tutorial.akash_retrofit_client_spring_boot.FutureStudioTutorial;

import com.tutorial.akash_retrofit_client_spring_boot.FutureStudioTutorial.dto.AuthorResponseDto;
import okhttp3.*;
import okio.Buffer;
import okio.BufferedSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;

public class FutureStudioRestClient {
    private static final Logger logger = LogManager.getLogger("FutureStudioRestClient");

    private String baseUrl;
    private List<AuthorResponseDto> responseResult;

    public FutureStudioRestClient(String baseUrl){
        this.baseUrl = baseUrl;

        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        HttpUrl httpUrl = original.url();

                        HttpUrl newHttpUrl = httpUrl.newBuilder().addQueryParameter("apikey", "Akash").build();

                        Request.Builder requestBuilder = original.newBuilder().url(newHttpUrl);
                        Request request = requestBuilder.build();

                        okhttp3.Response response = chain.proceed(request);

                        return customizeResponse(response);
                    }
                })
                .build();

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(this.baseUrl)
                .client(okHttpClient) //TODO: amra jei Custom OkHttpClient Banaisi sheita RetrofitBuild korar somoy dukailam
                .addConverterFactory(JacksonConverterFactory.create());
        Retrofit retrofitClient = retrofitBuilder.build();

        //TODO: this here means, amra "AuthorApiService" er jei INTERFACE Declare korsi... shei INTERFACE er CONCRETE CLASS(jaar moddhe Method Overrided ase) sheita return korbe
        AuthorApiService authorApiClient = retrofitClient.create(AuthorApiService.class);

        Call<List<AuthorResponseDto>> call = authorApiClient.getAllAuthors();
        try {
            Response<List<AuthorResponseDto>> result = call.execute();
            if(result.isSuccessful()){
                this.responseResult = result.body();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static okhttp3.Response customizeResponse(okhttp3.Response originalResponse) throws IOException {
        ResponseBody originalBody = originalResponse.body();
        BufferedSource source = originalBody.source();
        source.request(Long.MAX_VALUE); // Buffer the entire body
        Buffer buffer = source.buffer();
        String originalResponseBody = buffer.clone().readUtf8();

        // Add your custom data to the response body
        String modifiedResponseBody = addRoleToResponseBody(originalResponseBody);

        // Create a new response with the modified header+body
        okhttp3.Response modifiedResponse = originalResponse.newBuilder()
                .addHeader("role", "player")
                .body(ResponseBody.create(originalBody.contentType(), modifiedResponseBody))
                .build();

        return modifiedResponse;
    }

    private static String addRoleToResponseBody(String originalBody){
        // Here, you can parse the original JSON body and add the "role" field
        // For simplicity, let's assume the original body is a JSON string
        return originalBody.replace("}", ", \"club\": \"Real Madrid\"}");
    }


    public List<AuthorResponseDto> getResponseResult() {
        return responseResult;
    }

    public void setResponseResult(List<AuthorResponseDto> responseResult) {
        this.responseResult = responseResult;
    }
}
