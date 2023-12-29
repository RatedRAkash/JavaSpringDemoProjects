package com.psl.wso2_dummy.wso2.np.client.api;

import com.psl.wso2_dummy.wso2.np.dto.NotificationDto;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Body;

public interface NpBackendApiService {
    @POST("api/eventMessage/location")
    Call<Void> saveLocationData(@Body NotificationDto notificationDto);
}
