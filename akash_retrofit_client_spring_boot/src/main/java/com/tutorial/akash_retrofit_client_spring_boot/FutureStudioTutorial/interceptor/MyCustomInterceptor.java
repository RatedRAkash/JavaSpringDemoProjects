package com.tutorial.akash_retrofit_client_spring_boot.FutureStudioTutorial.interceptor;

import okhttp3.*;
import okio.Buffer;
import okio.BufferedSource;

import java.io.IOException;

public class MyCustomInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl httpUrl = original.url();

        HttpUrl newHttpUrl = httpUrl.newBuilder().addQueryParameter("apikey", "Akash").build();

        Request.Builder requestBuilder = original.newBuilder().url(newHttpUrl);
        Request request = requestBuilder.build();

        okhttp3.Response response = chain.proceed(request);

        return customizeResponse(response);
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
}
