package psl.np.common.utils;

import okhttp3.ResponseBody;
import psl.np.dataModel.constant.Errors;
import psl.np.dataModel.dto.error.ErrorDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class NpUtils {

    private static final Logger logger = LogManager.getLogger(NpUtils.class);

    public static String maskString(String value, int pad) {
        return maskString(value, pad, 5);
    }

    public static String maskString(String value, int pad, int maskSize) {
        if (value == null || value.length() <= (2*pad)) {
            return value;
        }
        String maskString = Strings.repeat("*", maskSize);
        return String.format("%s%s%s", value.substring(0, pad), maskString,
                value.substring(value.length() - pad));
    }

    public static ErrorDto buildErrorDto(BindingResult result) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setCode(Errors.VALIDATION_ERROR.getCode());
        errorDto.setMessage(Errors.VALIDATION_ERROR.getMessage());
        Map<String, String> errors = new HashMap<>();
        for (FieldError fe : result.getFieldErrors()) {
            errors.put(fe.getField(), fe.getDefaultMessage());
        }
        errorDto.setErrors(errors);
        return errorDto;
    }

    public static void addLogBuilder(HttpServletRequest request) {
        StringBuilder builder = new StringBuilder();
        builder.append("||| New Request: ");
        builder.append(buildUrl(request)).append("\n");
        request.setAttribute("startTime", System.currentTimeMillis());
        request.setAttribute("builder", builder);
    }

    public static String getProducedLog(HttpServletRequest request, HttpServletResponse response) {
        String logLine = String.format("||| Response: %s, Latency: %s", response.getStatus(), latency(request));
        Object obj = request.getAttribute("builder");
        if (obj != null && obj instanceof StringBuilder) {
            StringBuilder builder = (StringBuilder) obj;
            builder.append(logLine).append("\n");
            return builder.toString();
        } else {
            return logLine;
        }
    }

    public static long latency(HttpServletRequest request) {
        try {
            long start = Long.parseLong(request.getAttribute("startTime").toString());
            return System.currentTimeMillis() - start;
        } catch (Exception ignore) {
            logger.warn("Error getting request start time");
        }
        return -1;
    }

    public static String buildUrl(HttpServletRequest request) {
        StringBuilder builder = new StringBuilder();
        builder.append(request.getMethod()).append(" ");
        builder.append(request.getRequestURI());
        if (!Strings.isNullOrEmpty(request.getQueryString())) {
            builder.append("?");
            builder.append(request.getQueryString());
        }
        return builder.toString();
    }

    public static void prepareErrorResponse(HttpServletResponse response, int status, ErrorDto errorDto) {
        response.setStatus(status);
        response.setContentType("application/json;charset=UTF-8");
        try(PrintWriter writer = response.getWriter()) {
            MapperUtils.writeValue(writer, errorDto);
            logger.error(String.format("Status: %s, Error: %s", status, errorDto.toString()));
        } catch (IOException ex) {
            logger.error("Error writing string to response body", ex);
        }
    }

    public static ErrorDto deserializeErrorDto(ResponseBody errorBody) throws IOException {
        Errors error500 = Errors.INTERNAL_SERVER;
        String errorStr = null;
        if (errorBody != null) {
            errorStr = errorBody.string();
        }
        if (Strings.isNullOrEmpty(errorStr)) {
            logger.warn("Error response is: EMPTY");
            ErrorDto errorDto = new ErrorDto();
            errorDto.setCode(error500.getCode());
            errorDto.setMessage(error500.getMessage());
            return errorDto;
        }
        logger.warn("Error response: " + errorStr);
        ErrorDto errorDto = MapperUtils.toObject(errorStr, ErrorDto.class);
        if (errorDto.getCode() == 0) {
            errorDto.setCode(error500.getCode());
        }
        if (Strings.isNullOrEmpty(errorDto.getMessage())) {
            errorDto.setMessage(error500.getMessage());
        }
        return errorDto;
    }

    public static String processBaseUrl(String baseUrl) {
        if (Strings.isNullOrEmpty(baseUrl)) {
            return null;
        }
        if (!baseUrl.endsWith("/")) {
            baseUrl = baseUrl + "/";
        }
        return baseUrl;
    }
}
