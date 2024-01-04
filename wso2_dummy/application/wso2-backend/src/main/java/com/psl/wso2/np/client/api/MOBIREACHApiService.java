package com.psl.wso2.np.client.api;

import com.psl.wso2.np.dto.response.MobireachResponseDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface MOBIREACHApiService {
    @GET
    Call<MobireachResponseDto> sendSms(@Url String url,
            @Query("Username") String username,
            @Query("Password") String password,
            @Query("From") String smsMask,
            @Query("To") String mobile,
            @Query("Message") String message
    );
}
