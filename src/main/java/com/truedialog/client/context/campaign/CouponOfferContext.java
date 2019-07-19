package com.truedialog.client.context.campaign;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.campaign.CouponOffer;
import com.truedialog.client.rest.campaign.CouponOfferRest;

public class CouponOfferContext extends BaseContext {

    private CouponOfferRest.CouponOfferService couponOfferService;

    public CouponOfferContext(TrueDialogClient trueDialogClient, CouponOfferRest.CouponOfferService couponOfferService) {
        super(trueDialogClient);
        this.couponOfferService = couponOfferService;
    }

    public CouponOffer getById(int campaignId) {
        return getById(trueDialogClient.getCurrentAccount(), campaignId);
    }

    public CouponOffer getById(int campaignId, boolean throwIfEmpty) {
        return getById(trueDialogClient.getCurrentAccount(), campaignId, throwIfEmpty);
    }

    public CouponOffer getById(int accountId, int campaignId) {
        return executeEntityCall(couponOfferService.getCouponOffer(accountId, campaignId));
    }

    public CouponOffer getById(int accountId, int campaignId, boolean throwIfEmpty) {
        return executeEntityCall(couponOfferService.getCouponOffer(accountId, campaignId), throwIfEmpty);
    }

    public CouponOffer create(int accountId, int campaignId, CouponOffer offer) {
        return executeEntityCall(couponOfferService.createCouponOffer(accountId, campaignId, offer), true);
    }

    public CouponOffer create(int campaignId, CouponOffer offer) {
        int accountId = offer.getAccountId() > 0 ? offer.getAccountId() : trueDialogClient.getCurrentAccount();
        return create(accountId, campaignId, offer);
    }

    public CouponOffer create(CouponOffer offer) {
        if (offer.getCampaignId() == 0)
            throw new IllegalArgumentException("Campaign ID is missing.");

        int accountId = offer.getAccountId() > 0 ? offer.getAccountId() : trueDialogClient.getCurrentAccount();
        return create(accountId, offer.getCampaignId(), offer);
    }

    public CouponOffer update(int accountId, int campaignId, CouponOffer offer) {
        return executeEntityCall(couponOfferService.updateCouponOffer(accountId, campaignId, offer), true);
    }

    public CouponOffer update(int campaignId, CouponOffer offer) {
        int accountId = offer.getAccountId() > 0 ? offer.getAccountId() : trueDialogClient.getCurrentAccount();
        return update(accountId, campaignId, offer);
    }

    public CouponOffer update(CouponOffer offer) {
        if (offer.getCampaignId() == 0)
            throw new IllegalArgumentException("Campaign ID is missing.");

        int accountId = offer.getAccountId() > 0 ? offer.getAccountId() : trueDialogClient.getCurrentAccount();
        return update(accountId, offer.getCampaignId(), offer);
    }

    public void delete(int accountId, int campaignId) {
        executeEntityCall(couponOfferService.deleteCouponOffer(accountId, campaignId), true);
    }

    public void delete(int campaignId) {
        delete(trueDialogClient.getCurrentAccount(), campaignId);
    }
}
