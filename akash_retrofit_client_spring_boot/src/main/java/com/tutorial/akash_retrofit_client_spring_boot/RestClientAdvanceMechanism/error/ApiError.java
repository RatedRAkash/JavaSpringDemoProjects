package com.tutorial.akash_retrofit_client_spring_boot.RestClientAdvanceMechanism.error;

import com.google.gson.annotations.SerializedName;

public class ApiError {

    @SerializedName("status")
    private int statusCode;
    @SerializedName("error")
    private String message = "Unknown error";

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
