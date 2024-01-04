package com.psl.wso2.np.client.api;

import com.psl.wso2.np.dto.request.TallykhataVendorRequestDto;
import com.psl.wso2.np.dto.response.TallykhataVendorResponseDto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface TallykhataApiService {
    @POST
    Call<TallykhataVendorResponseDto> sendSms(@Url String url, @Body TallykhataVendorRequestDto requestDto);
}