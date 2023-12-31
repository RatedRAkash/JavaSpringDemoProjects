package com.psl.wso2_dummy.wso2.np.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FCMResponseDto implements Serializable {
    private String success;
    private String failure;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getFailure() {
        return failure;
    }

    public void setFailure(String failure) {
        this.failure = failure;
    }

    @Override
    public String toString() {
        return "FCMResponseDto {" +
                "success='" + success + '\'' +
                ", failure='" + failure + '\'' +
                '}';
    }
}
