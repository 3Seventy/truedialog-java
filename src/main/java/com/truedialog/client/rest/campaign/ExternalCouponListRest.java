package com.truedialog.client.rest.campaign;

import com.truedialog.client.model.campaign.ExternalCouponCode;
import com.truedialog.client.model.campaign.ExternalCouponList;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public class ExternalCouponListRest {

    private static final String EXTERNAL_COUPON_LIST = "account/{accountId}/external-couponlist";
    private static final String EXTERNAL_COUPON_ITEM = "account/{accountId}/external-couponlist/{listId}";
    private static final String EXTERNAL_COUPON_CREATE = "account/{accountId}/external-couponlist";
    private static final String EXTERNAL_COUPON_UPDATE = "account/{accountId}/external-couponlist/{listId}";
    private static final String EXTERNAL_COUPON_DELETE = "account/{accountId}/external-couponlist/{listId}";
    private static final String EXTERNAL_COUPON_CODE_LIST = "account/{accountId}/external-couponlist/{listId}/code";


    public interface ExternalCouponListService {

        @GET(EXTERNAL_COUPON_LIST)
        Call<List<ExternalCouponList>> getExternalCouponList(@Path("accountId") int accountId);

        @GET(EXTERNAL_COUPON_ITEM)
        Call<ExternalCouponList> getExternalCoupon(@Path("accountId") int accountId, @Path("listId") int listId);

        @GET(EXTERNAL_COUPON_CREATE)
        Call<ExternalCouponList> createExternalCoupon(@Path("accountId") int accountId, @Body ExternalCouponList externalCouponList);

        @GET(EXTERNAL_COUPON_UPDATE)
        Call<ExternalCouponList> updateExternalCoupon(@Path("accountId") int accountId, @Path("listId") int listId, @Body ExternalCouponList externalCouponList);

        @GET(EXTERNAL_COUPON_DELETE)
        Call<Void> deleteExternalCoupon(@Path("accountId") int accountId, @Path("listId") int listId);

        @GET(EXTERNAL_COUPON_CODE_LIST)
        Call<List<ExternalCouponCode>> getExternalCouponCodeList(@Path("accountId") int accountId, @Path("listId") int listId);
    }
}
