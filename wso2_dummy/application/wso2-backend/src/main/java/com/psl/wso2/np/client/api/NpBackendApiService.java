package com.psl.wso2.np.client.api;

import com.psl.wso2.np.dto.NotificationDto;
import com.psl.wso2.np.dto.response.BankInfoResponseDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Body;

import java.util.List;

public interface NpBackendApiService {
    @POST("api/eventMessage/location")
    Call<Void> saveLocationData(@Body NotificationDto notificationDto);

    @GET("api/account/bank")
    Call<List<BankInfoResponseDto>> getBankInfo();
}
