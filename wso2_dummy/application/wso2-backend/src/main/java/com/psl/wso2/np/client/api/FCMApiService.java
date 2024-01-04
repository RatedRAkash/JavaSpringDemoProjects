package com.psl.wso2.np.client.api;

import com.psl.wso2.np.dto.formatted_dto.PushTemplateFormattedDto;
import com.psl.wso2.np.dto.response.FCMResponseDto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface FCMApiService {
    @POST("fcm/send")
    Call<FCMResponseDto> sendMessage(@Body PushTemplateFormattedDto pushTemplateFormattedDto, @Body String fcmToken);
}
