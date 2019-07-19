package com.truedialog.client.rest.campaign;

import com.truedialog.client.model.campaign.CouponDefinition;
import com.truedialog.client.model.campaign.CouponRedemption;
import com.truedialog.client.model.campaign.CouponRedemptionDetails;
import retrofit2.Call;
import retrofit2.http.*;

public class CouponDefinitionRest {

    private static final String COUPON_DEFINITION_ITEM = "account/{accountId}/campaign/{campaignId}/coupon";
    private static final String COUPON_DEFINITION_CREATE = "account/{accountId}/campaign/{campaignId}/coupon";
    private static final String COUPON_DEFINITION_UPDATE = "account/{accountId}/campaign/{campaignId}/coupon";
    private static final String REDEEM = "account/{accountId}/event-redeemcoupon";
    private static final String REDEMPTION_DETAILS = "account/{accountId}/campaign/{campaignId}/coupon/redemptions";

    public interface CouponDefinitionService {

        @GET(COUPON_DEFINITION_ITEM)
        Call<CouponDefinition> getCouponDefinition(@Path("accountId") int accountId, @Path("campaignId") int campaignId);

        @POST(COUPON_DEFINITION_CREATE)
        Call<CouponDefinition> createCouponDefinition(@Path("accountId") int accountId, @Path("campaignId") int campaignId, @Body CouponDefinition definition);

        @PUT(COUPON_DEFINITION_UPDATE)
        Call<CouponDefinition> updateCouponDefinition(@Path("accountId") int accountId, @Path("campaignId") int campaignId, @Body CouponDefinition definition);

        @POST(REDEEM)
        Call<CouponRedemption> redeem(@Path("accountId") int accountId, @Body String couponCode);

        @GET(REDEMPTION_DETAILS)
        Call<CouponRedemptionDetails> redemptionDetails(@Path("accountId") int accountId, @Path("campaignId") int campaignId);
    }
}
