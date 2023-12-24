package com.tutorial.akash_retrofit_client_spring_boot.FutureStudioTutorial;

import com.tutorial.akash_retrofit_client_spring_boot.FutureStudioTutorial.dto.AuthorResponseDto;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface AuthorApiService {

    @GET("/authors")
    Call<List<AuthorResponseDto>> getAllAuthors();
}
