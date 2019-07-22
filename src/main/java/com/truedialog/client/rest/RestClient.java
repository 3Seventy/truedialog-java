package com.truedialog.client.rest;

import com.truedialog.client.config.TrueDialogConfig;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RestClient {

    private Map<Class, Object> services = Collections.synchronizedMap(new HashMap<>());
    private static final String AUTH_HEADER = "Authorization";
    private static final String USER_AGENT_HEADER = "User-Agent";
    private static final String ACCEPT_HEADER = "Accept";

    private final Retrofit retrofit;

    private RestClient(TrueDialogConfig configuration) {
        String authCredentials = Credentials.basic(configuration.getAuthConfig().getUserName(),
                configuration.getAuthConfig().getPassword());

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request.Builder builder = chain.request().newBuilder()
                            .addHeader(ACCEPT_HEADER, "application/json")
                            .addHeader(AUTH_HEADER, authCredentials);
                    String userAgent = configuration.getUserAgent();
                    if (userAgent != null && !userAgent.isEmpty()){
                        builder.addHeader(USER_AGENT_HEADER, userAgent);
                    }
                    Request newRequest = builder.build();
                    return chain.proceed(newRequest);
                })
                .callTimeout(configuration.getHttpTimeout(), TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public static RestClient fromClientConfig(TrueDialogConfig configuration) {
        return new RestClient(configuration);
    }


    @SuppressWarnings("unchecked")
    public <TService> TService getService(Class<TService> clazz) {

        if (services.containsKey(clazz)) {
            return (TService) services.get(clazz);
        } else {
            TService tService = retrofit.create(clazz);
            services.put(clazz, tService);
            return tService;
        }
    }
}
