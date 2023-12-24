package com.tutorial.akash_retrofit_client_spring_boot.RestClientAdvanceMechanism;
import com.google.common.collect.Lists;
import okhttp3.Interceptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class RMARestClient<TService, TDto> {
    //TODO:
    // *** TService --> jeita ApiService Class Call dibo taar Name ***
    // *** TDto --> jeita RESPONSE ee ashbe sheitar TYPE ***

    private static final Logger logger = LogManager.getLogger("RMARestClient");

    private String baseUrl;
    private Consumer<ErrorDto> failureHandler;
    private List<Interceptor> interceptorsList = new ArrayList<>();

    private String methodName; //Only for logging purpose

    private int timeout;

// *********** Constructors ***********
    public RMARestClient(String baseUrl) {
        this.baseUrl = baseUrl;
        methodName = "Calling api service";
        timeout = 60;
    }

    public RMARestClient(){
        this(null);
    }

// *********** Methods ***********
    public RMARestClient<TService, TDto> setBaseUrl(String baseUrl){ // return kortesei ei CLASS er ei ekta OBJECT, jeno shei Object ke pore Manipulate kore arro ei CLASS er Other Methods call korte pari
        this.baseUrl = baseUrl;
        return this;
    }

    public RMARestClient<TService, TDto> addInterceptor(Interceptor... interceptors){
        interceptorsList.addAll(Lists.newArrayList(interceptors));
        return this; // ei Class kei Return kore dilam, jate jeikhan theke Call hocche Method sheikhane Chain kore method Call kora jay
    }

    public RMARestClient<TService, TDto> setTimeout(int timeout) {
        if (timeout > 0) {
            this.timeout = timeout;
        }
        return this;
    }

    public RMARestClient<TService, TDto> onFailure(Consumer<ErrorDto> failureHandler) {
        this.failureHandler = failureHandler;
        return this;
    }

    /**
     * Set the calling method name for logging only
     * @param methodName name of the action to perform
     * @return Instance of Client
     */
    public RMARestClient<TService, TDto> methodName(String methodName) {
        this.methodName = "Calling api service for: " + methodName;
        return this;
    }

// *********** API Calling Methods ***********
    public TDto callApi(Class<TService> tServiceClass, Function<TService, Call<TDto>> action) throws Exception{

        // TODO: tServiceClass Object theke, TService er Type er Object Create korbo RetrofitClient Create korar somoy
        TService tServiceClassObj = ClientHelper.buildRetrofitClient(tServiceClass, baseUrl, timeout,
                interceptorsList.toArray(new Interceptor[0]));
        Response<TDto> response = null;
        try {
            logger.info(methodName);
            response = action.apply(tServiceClassObj).execute();
        } catch (SocketTimeoutException ex) {
            logger.error("Calling service timeout", ex);
//            throw new NpTimeOutException();
        } catch (IOException ex) {
            logger.error("Unable to call Service", ex);
//            throw new NpServiceCallException();
        }

        logger.info("Api service response: " + response.code());


        return response.body();
    }

}
