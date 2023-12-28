package psl.np.common.restClient;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class BasicAuthInterceptor implements Interceptor {

    private static final String AUTH_HEADER = "Authorization";
    private final String basicAuth;

    public BasicAuthInterceptor(String userName, String password) {
        this.basicAuth = Credentials.basic(userName, password);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        request = request.newBuilder()
                .addHeader(AUTH_HEADER, this.basicAuth)
                .build();
        return chain.proceed(request);
    }
}
