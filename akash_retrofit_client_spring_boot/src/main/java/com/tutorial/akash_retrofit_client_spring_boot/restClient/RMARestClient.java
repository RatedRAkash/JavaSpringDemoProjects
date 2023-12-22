package com.tutorial.akash_retrofit_client_spring_boot.restClient;
import okhttp3.Interceptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class RMARestClient<TService, TDto> {
    private static final Logger logger = LogManager.getLogger("RMARestClient");

    private String baseUrl;
    private Consumer<ErrorDto> failureHandler;
    private List<Interceptor> interceptorsList = new ArrayList<>();

    private String methodName; //Only for logging purpose

    private int timeout;

//  Constructors
    public RMARestClient(String baseUrl) {
        this.baseUrl = baseUrl;
        methodName = "Calling api service";
        timeout = 60;
    }

    public RMARestClient(){
        this(null);
    }

//  Methods
    public RMARestClient<TService, TDto> setBaseUrl(String baseUrl){ // return kortesei ei CLASS er ei ekta OBJECT, jeno shei Object ke pore Manipulate kore arro ei CLASS er Other Methods call korte pari
        this.baseUrl = baseUrl;
        return this;
    }

}
