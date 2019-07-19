package com.truedialog.client.rest.channel;

import com.truedialog.client.model.channel.LongCode;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public class LongCodeRest {

    private static final String LONG_CODE_LIST = "account/{accountId}/long-code/";
    private static final String LONG_CODE_DIRECT_LIST = "account/{accountId}/long-code-direct/";
    private static final String LONG_CODE_FORWARDING = "account/{accountId}/long-code/{longCode}/callforwarding";
    private static final String LONG_CODE_FORWARDING_VERIFICATION = "account/{accountId}/long-code/{longCode}/callforwardingverification";


    public interface LongCodeService {

        @GET(LONG_CODE_LIST)
        Call<List<String>> getRawList(@Path("accountId") int accountId);

        @GET(LONG_CODE_DIRECT_LIST)
        Call<List<LongCode>> getLongCodeList(@Path("accountId") int accountId);

        @POST(LONG_CODE_FORWARDING)
        Call<LongCode> addForwarding(@Path("accountId") int accountId, @Path("longCode") String longCode, @Body String forwardingNumber);

        @POST(LONG_CODE_FORWARDING)
        Call<LongCode> removeForwarding(@Path("accountId") int accountId, @Path("longCode") String longCode);

        @POST(LONG_CODE_FORWARDING_VERIFICATION)
        Call<LongCode> verifyForwarding(@Path("accountId") int accountId, @Path("longCode") String longCode, @Body String verificationCode);
    }
}
