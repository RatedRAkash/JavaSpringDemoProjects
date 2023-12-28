package psl.np.common.restClient;

import com.google.common.collect.Lists;
import psl.np.common.constant.Constant;
import psl.np.common.error.NpException;
import psl.np.common.error.NpServiceCallException;
import psl.np.common.error.NpTimeOutException;
import psl.np.dataModel.constant.Errors;
import psl.np.dataModel.dto.error.ErrorDto;
import psl.np.common.utils.MapperUtils;
import psl.np.common.utils.Strings;
import okhttp3.Interceptor;
import okhttp3.ResponseBody;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class NpRestClient<TService, TDto> {

    private static final Logger logger = LogManager.getLogger("psl.np.common.NpRestClient");

    private String baseUrl;
    private Consumer<ErrorDto> failureHandler;
    private List<Interceptor> interceptors = new ArrayList<>();
    private String methodName; //Only for logging purpose
    private int timeout;

    public NpRestClient() {
        this(null);
    }

    public NpRestClient(String baseUrl) {
        this.baseUrl = checkBaseUrl(baseUrl);
        methodName = "Calling api service";
        timeout = 60;
    }

    public NpRestClient<TService, TDto> setBaseUrl(String baseUrl) {
        this.baseUrl = checkBaseUrl(baseUrl);
        return this;
    }

    public NpRestClient<TService, TDto> addInterceptor(Interceptor... interceptorList) {
        interceptors.addAll(Lists.newArrayList(interceptorList));
        return this;
    }

    public NpRestClient<TService, TDto> setTimeout(int timeout) {
        if (timeout > 0) {
            this.timeout = timeout;
        }
        return this;
    }

    public NpRestClient<TService, TDto> onFailure(Consumer<ErrorDto> failureHandler) {
        this.failureHandler = failureHandler;
        return this;
    }

    /**
     * Set the calling method name for logging only
     * @param methodName name of the action to perform
     * @return Instance of Client
     */
    public NpRestClient<TService, TDto> methodName(String methodName) {
        this.methodName = "Calling api service for: " + methodName;
        return this;
    }

    public TDto callApi(Class<TService> tServiceClass, Function<TService, Call<TDto>> action)
            throws NpException {
        TService service = ClientHelper.buildClient(tServiceClass, baseUrl, timeout,
                interceptors.toArray(new Interceptor[0]));
        Response<TDto> response = null;
        try {
            logger.info(methodName);
            response = action.apply(service).execute();
        } catch (SocketTimeoutException ex) {
            logger.error("Calling service timeout", ex);
            throw new NpTimeOutException();
        } catch (IOException ex) {
            logger.error("Unable to call Service", ex);
            throw new NpServiceCallException();
        }
        logger.info("Api service response: " + response.code());
        if (!response.isSuccessful()) {
            ErrorDto errorDto;
            try {
                errorDto = deserializeErrorDto(response.errorBody());
            } catch (IOException ex) {
                logger.error("Unable to read error body", ex);
                throw new NpServiceCallException();
            }
            if (failureHandler != null) {
                failureHandler.accept(errorDto);
            } else {
                throw new NpException(response.code(), errorDto);
            }
        }
        return response.body();
    }
    public void callApiAsync(Class<TService> tServiceClass, Function<TService, Call<TDto>> action){
        callApiAsync(tServiceClass, action, null);
    }

    public void callApiAsync(Class<TService> tServiceClass, Function<TService, Call<TDto>> action, String authToken) {
        if (Strings.notBlank(authToken)) {
            interceptors.add(new AddHeaderInterceptor(Constant.AUTH_HEADER, authToken));
        }
        TService service = ClientHelper.buildClient(tServiceClass, baseUrl, timeout,
                interceptors.toArray(new Interceptor[0]));
        logger.info(methodName + " asynchronously");
        action.apply(service).enqueue(new Callback<TDto>() {
            @Override
            public void onResponse(Call<TDto> call, Response<TDto> response) {
                if (!response.isSuccessful()) {
                    try {
                        ErrorDto errorDto = deserializeErrorDto(response.errorBody());
                        if (failureHandler != null) {
                            failureHandler.accept(errorDto);
                        }
                    } catch (IOException e) {
                        logger.error("Unable to read error body", e);
                    }
                }
            }

            @Override
            public void onFailure(Call<TDto> call, Throwable t) {
                logger.fatal("Error calling api", t);
            }
        });
    }

    private String checkBaseUrl(String baseUrl) {
        if (Strings.isNullOrEmpty(baseUrl)) {
            return null;
        }
        if (!baseUrl.endsWith("/")) {
            baseUrl = baseUrl + "/";
        }
        return baseUrl;
    }

    private ErrorDto deserializeErrorDto(ResponseBody errorBody) throws IOException {
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
}
