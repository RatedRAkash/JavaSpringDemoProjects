package com.tutorial.akash_retrofit_client_spring_boot.RestClientAdvanceMechanism.error;

import java.io.IOException;
import java.lang.annotation.Annotation;

import com.tutorial.akash_retrofit_client_spring_boot.RestClientAdvanceMechanism.ClientHelper;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Created by AnantaAkashPodder on 25/12/2023.
 */
public class ErrorUtils {

                           //TODO: eita mane jekono TYPE Response Argument hisave nite parbe, like Response<Author>, Response<Player> etc.
    public static ApiError parseErrorFromResponse(Response<?> response) {

        Converter<ResponseBody, ApiError> converter =
                ClientHelper.getRetrofitInstance()
                .responseBodyConverter(ApiError.class, new Annotation[0]);

        ApiError error;
        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new ApiError();
        }

        return error;
    }
}
