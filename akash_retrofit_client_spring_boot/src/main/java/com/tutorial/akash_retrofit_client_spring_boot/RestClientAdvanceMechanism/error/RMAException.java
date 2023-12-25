package com.tutorial.akash_retrofit_client_spring_boot.RestClientAdvanceMechanism.error;



import com.tutorial.akash_retrofit_client_spring_boot.RestClientAdvanceMechanism.error.dto.ErrorDto;
import retrofit2.Response;

import java.util.Map;
public class RMAException extends Exception {

    private static final long serialVersionUID = 1L;

    private int status;
    private int code;
    private ErrorDto errorDto;

    public RMAException() {
        this(500, "Something went wrong in server");
    }

    public RMAException(String message) {
        this(500, message);
    }

    public RMAException(int status, String message) {
        this(status, 5000, message);
    }

    public RMAException(int status, int code, String message) {
        super(message);
        this.status = status;
        this.code = code;
    }
    public RMAException(int status, int code, String message, Map<String, String> errors) {
        super(message);
        this.status = status;
        this.code = code;
        this.errorDto=new ErrorDto();
        errorDto.setErrors(errors);
    }

    public RMAException(int status, ErrorDto errorDto) {
        super(errorDto.getMessage());
        this.status = status;
        this.errorDto = errorDto;
    }

    public RMAException(Response errorResponse) {
        super(ErrorUtils.parseErrorFromResponse(errorResponse).getMessage());
    }


//    public RMAException(Errors error) {
//        this(error.getHttpCode(), error.getCode(), error.getMessage());
//    }
//
//    public RMAException(Errors error, Object... values) {
//        this(error.getHttpCode(), error.getCode(), String.format(error.getMessage(), values));
//    }

    public ErrorDto getErrorDto() {
        if (errorDto == null) {
            errorDto = new ErrorDto();
            errorDto.setCode(code);
            errorDto.setMessage(getMessage());
        }
        return errorDto;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}