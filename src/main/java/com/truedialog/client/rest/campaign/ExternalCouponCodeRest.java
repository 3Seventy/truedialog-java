package com.truedialog.client.rest.campaign;

import com.truedialog.client.model.campaign.ExternalCouponCode;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public class ExternalCouponCodeRest {

    private static final String EXTERNAL_COUPON_CODE_LIST = "account/{accountId}/external-couponlist/{listId}/code";
    private static final String EXTERNAL_COUPON_CODE_ITEM = "account/{accountId}/external-couponlist/{listId}/code/{couponcode}";
    private static final String EXTERNAL_COUPON_CODE_DELETE = "account/{accountId}/external-couponlist/{listId}/code/{couponcode}";


    public interface ExternalCouponCodeService {

        @GET(EXTERNAL_COUPON_CODE_LIST)
        Call<List<ExternalCouponCode>> getExternalCouponCodeList(@Path("accountId") int accountId, @Path("listId") int listId);

        @GET(EXTERNAL_COUPON_CODE_ITEM)
        Call<ExternalCouponCode> getExternalCouponCode(@Path("accountId") int accountId, @Path("listId") int listId, @Path("couponcode") String couponCode);

        @DELETE(EXTERNAL_COUPON_CODE_DELETE)
        Call<Void> deleteExternalCouponCode(@Path("accountId") int accountId, @Path("listId") int listId, @Path("couponcode") String couponCode);
    }
}
