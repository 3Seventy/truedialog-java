package com.truedialog.client.context;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.enums.ResponseStatus;
import com.truedialog.client.exceptions.NetworkException;
import com.truedialog.client.exceptions.RemoteException;
import com.truedialog.client.model.error.ErrorDetail;
import retrofit2.Call;
import retrofit2.HttpException;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public abstract class BaseContext {

    protected TrueDialogClient trueDialogClient;

    public BaseContext(TrueDialogClient trueDialogClient) {
        this.trueDialogClient = trueDialogClient;
    }

    protected <TEntity> TEntity executeEntityCall(Call<TEntity> call, boolean throwIfEmpty) {
        try {
            Response<TEntity> response = call.execute();
            if (response.isSuccessful()) {
                if (response.code() == ResponseStatus.NO_CONTENT) {
                    if (throwIfEmpty) {
                        throw new HttpException(response);
                    }
                    return null;
                } else {
                    return response.body();
                }
            } else {
                parseError(response);
            }
        } catch (IOException e) {
            throw new NetworkException(e.getMessage(), e);
        }
        return null;
    }


    protected <TEntity> TEntity executeEntityCall(Call<TEntity> call) {
        return executeEntityCall(call, true);
    }

    protected <TEntity> List<TEntity> executeEntityListCall(Call<List<TEntity>> call, boolean throwIfEmpty) {
        try {
            Response<List<TEntity>> response = call.execute();
            if (response.isSuccessful()) {
                if (response.code() == ResponseStatus.NO_CONTENT) {
                    if (throwIfEmpty) {
                        throw new HttpException(response);
                    }
                    return new ArrayList<>();
                } else {
                    return response.body();
                }
            } else {
                parseError(response);
            }
        } catch (IOException e) {
            throw new NetworkException(e.getMessage(), e);
        }
        return null;
    }

    protected <TEntity> List<TEntity> executeEntityListCall(Call<List<TEntity>> call) {
        return executeEntityListCall(call, false);
    }

    private void parseError(Response<?> response) throws IOException {
        String errorBody = null;
        if (response.errorBody() != null) {
            errorBody = response.errorBody().string();
        }
        try {
            throw new RemoteException(response.code(), new ObjectMapper().readValue(errorBody, new TypeReference<List<ErrorDetail>>() { // try to parse response for errorDetails
            }));
        } catch (Exception e) {
            if (response.errorBody() != null) {
                throw new NetworkException(errorBody); // try to read errorBody
            }
            throw new HttpException(response); // throw default httpException with response info
        }
    }
}
