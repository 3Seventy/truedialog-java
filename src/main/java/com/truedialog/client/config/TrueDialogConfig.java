package com.truedialog.client.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TrueDialogConfig {


    private static final String PROPERTY_PREFIX = "com.truedialog.client.";

    private TrueDialogConfig(AuthConfig authConfig) {
        this.authConfig = authConfig;
    }

    private final static String DEFAULT_URL = "https://api.truedialog.com/api/v2.1/";

    private final static String DEFAULT_TIME_OUT = "20";

    /**
     * Base URL where requests are sent to.
     */
    private String baseUrl;

    /**
     * Authorization details
     */
    private AuthConfig authConfig;

    /**
     * The retry policy configuration.
     */
    private RetryConfig retryPolicy;

    /**
     * The timeout value in seconds we will wait for a response from the server.
     */
    private Integer httpTimeout;

    /**
     * The user agent string to use when sending HTTP requests.
     */
    private String userAgent;

    public String getBaseUrl() {
        return baseUrl;
    }

    public AuthConfig getAuthConfig() {
        return authConfig;
    }

    public RetryConfig getRetryPolicy() {
        return retryPolicy;
    }

    public int getHttpTimeout() {
        return httpTimeout;
    }

    public String getUserAgent() {
        return userAgent;
    }


    public static TrueDialogConfig fromConfigFile() {
        Properties properties = new Properties();

        InputStream input = TrueDialogConfig.class.getClassLoader().getResourceAsStream("config.properties");

        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String userName = properties.getProperty(PROPERTY_PREFIX + "userName");
        String password = properties.getProperty(PROPERTY_PREFIX + "password");

        return new TrueDialogConfig.TrueDialogClientConfigBuilder(new AuthConfig(userName, password))
                .setBaseUrl(properties.getProperty(PROPERTY_PREFIX + "baseUrl", DEFAULT_URL))
                .setHttpTimeout(Integer.parseInt(properties.getProperty(PROPERTY_PREFIX + "timeout", DEFAULT_TIME_OUT)))
                .setUserAgent(properties.getProperty(PROPERTY_PREFIX + "userAgent"))
                .setRetryPolicy(readRetryConfig(properties))
                .build();

    }

    private static RetryConfig readRetryConfig(Properties properties) {
        RetryConfig retryConfig = new RetryConfig();

        retryConfig.setEnabled(Boolean.getBoolean(properties.getProperty(PROPERTY_PREFIX + "enabled", "false")));
        retryConfig.setInterval(Long.parseLong(properties.getProperty(PROPERTY_PREFIX + "interval", "0")));
        retryConfig.setMaxInterval(Long.parseLong(properties.getProperty(PROPERTY_PREFIX + "maxInterval", "500")));
        retryConfig.setMinInterval(Long.parseLong(properties.getProperty(PROPERTY_PREFIX + "minInterval", "10000")));
        retryConfig.setMaxTries(Integer.parseInt(properties.getProperty(PROPERTY_PREFIX + "maxTries", "3")));
        try {
            retryConfig.setTypeName(properties.getProperty(PROPERTY_PREFIX + "type", ""));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return retryConfig;
    }

    /**
     * The builder class
     * internal use
     */
    static class TrueDialogClientConfigBuilder {

        private AuthConfig builderAuthConfig;
        private String builderBaseUrl;
        private RetryConfig builderRetryPolicy;
        private Integer builderHttpTimeout;
        private String builderUserAgent;

        TrueDialogClientConfigBuilder(AuthConfig authConfig) {
            this.builderAuthConfig = authConfig;
        }

        TrueDialogClientConfigBuilder setBaseUrl(String baseUrl) {
            if (baseUrl == null || baseUrl.isEmpty()) {
                baseUrl = DEFAULT_URL;
            }
            builderBaseUrl = baseUrl;
            return this;
        }

        TrueDialogClientConfigBuilder setRetryPolicy(RetryConfig retryPolicy) {
            builderRetryPolicy = retryPolicy;
            return this;
        }

        TrueDialogClientConfigBuilder setHttpTimeout(Integer httpTimeout) {
            builderHttpTimeout = httpTimeout;
            return this;
        }

        TrueDialogClientConfigBuilder setUserAgent(String userAgent) {
            builderUserAgent = userAgent;
            return this;
        }

        TrueDialogConfig build() {
            TrueDialogConfig trueDialogConfig = new TrueDialogConfig(builderAuthConfig);

            if (this.builderBaseUrl == null || this.builderBaseUrl.isEmpty()) {
                trueDialogConfig.baseUrl = DEFAULT_URL;
            } else {
                trueDialogConfig.baseUrl = this.builderBaseUrl;
            }
            if (this.builderHttpTimeout == null) {
                trueDialogConfig.httpTimeout = Integer.parseInt(DEFAULT_TIME_OUT);
            } else {
                trueDialogConfig.httpTimeout = builderHttpTimeout;
            }
            trueDialogConfig.httpTimeout = this.builderHttpTimeout;
            trueDialogConfig.retryPolicy = this.builderRetryPolicy;
            trueDialogConfig.userAgent = this.builderUserAgent;
            return trueDialogConfig;
        }
    }
}
