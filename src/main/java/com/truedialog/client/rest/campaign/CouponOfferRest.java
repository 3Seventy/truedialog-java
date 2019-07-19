package com.truedialog.client.rest.campaign;

import com.truedialog.client.model.campaign.CouponOffer;
import retrofit2.Call;
import retrofit2.http.*;

public class CouponOfferRest {

    private static final String COUPON_OFFER_ITEM = "account/{accountId}/campaign/{campaignId}/couponOffer";
    private static final String COUPON_OFFER_CREATE = "account/{accountId}/campaign/{campaignId}/couponOffer";
    private static final String COUPON_OFFER_UPDATE = "account/{accountId}/campaign/{campaignId}/couponOffer";
    private static final String COUPON_OFFER_DELETE = "account/{accountId}/campaign/{campaignId}/couponOffer";

    public interface CouponOfferService {

        @GET(COUPON_OFFER_ITEM)
        Call<CouponOffer> getCouponOffer(@Path("accountId") int accountId, @Path("campaignId") int campaignId);

        @POST(COUPON_OFFER_CREATE)
        Call<CouponOffer> createCouponOffer(@Path("accountId") int accountId, @Path("campaignId") int campaignId, @Body CouponOffer couponOffer);

        @PUT(COUPON_OFFER_UPDATE)
        Call<CouponOffer> updateCouponOffer(@Path("accountId") int accountId, @Path("campaignId") int campaignId, @Body CouponOffer couponOffer);

        @DELETE(COUPON_OFFER_DELETE)
        Call<Void> deleteCouponOffer(@Path("accountId") int accountId, @Path("campaignId") int campaignId);
    }
}
