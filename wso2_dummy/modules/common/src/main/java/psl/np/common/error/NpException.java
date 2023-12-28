package psl.np.common.error;

import psl.np.dataModel.constant.Errors;
import psl.np.dataModel.dto.error.ErrorDto;

import java.util.Map;

public class NpException extends Exception {

    private static final long serialVersionUID = 1L;

    private int status;
    private int code;
    private ErrorDto errorDto;

    public NpException() {
        this(500, "Something went wrong in server");
    }

    public NpException(String message) {
        this(500, message);
    }

    public NpException(int status, String message) {
        this(status, 5000, message);
    }

    public NpException(int status, int code, String message) {
        super(message);
        this.status = status;
        this.code = code;
    }
    public NpException(int status, int code, String message, Map<String, String> errors) {
        super(message);
        this.status = status;
        this.code = code;
        this.errorDto=new ErrorDto();
        errorDto.setErrors(errors);
    }

    public NpException(int status, ErrorDto errorDto) {
        super(errorDto.getMessage());
        this.status = status;
        this.errorDto = errorDto;
    }

    public NpException(Errors error) {
        this(error.getHttpCode(), error.getCode(), error.getMessage());
    }

    public NpException(Errors error, Object... values) {
        this(error.getHttpCode(), error.getCode(), String.format(error.getMessage(), values));
    }

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
