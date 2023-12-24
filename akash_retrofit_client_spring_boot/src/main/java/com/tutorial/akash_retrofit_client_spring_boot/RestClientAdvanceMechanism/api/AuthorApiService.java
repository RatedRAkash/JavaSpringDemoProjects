package com.tutorial.akash_retrofit_client_spring_boot.RestClientAdvanceMechanism.api;

import com.tutorial.akash_retrofit_client_spring_boot.RestClientAdvanceMechanism.dto.AuthorResponseDto;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface AuthorApiService {

    @GET("authors")
    Call<List<AuthorResponseDto>> getAllAuthors();
}
