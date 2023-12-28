package psl.np.common.restClient;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddHeaderInterceptor implements Interceptor {

    private String headerName;
    private String headerValue;

    public AddHeaderInterceptor(String headerName, String headerValue) {
        this.headerName = headerName;
        this.headerValue = headerValue;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder().addHeader(headerName, headerValue).build();
        return chain.proceed(request);
    }

    public List<Interceptor> interceptorList(HashMap<String, String> headerMap){
        List<Interceptor> interceptorList = new ArrayList<>();
        headerMap.forEach((k, v) -> interceptorList.add(new AddHeaderInterceptor(k, v)));
        return interceptorList;
    }
}
