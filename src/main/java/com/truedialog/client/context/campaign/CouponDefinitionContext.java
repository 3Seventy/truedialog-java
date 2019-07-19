package com.truedialog.client.context.campaign;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.campaign.CouponDefinition;
import com.truedialog.client.model.campaign.CouponRedemption;
import com.truedialog.client.model.campaign.CouponRedemptionDetails;
import com.truedialog.client.rest.campaign.CouponDefinitionRest;
import com.truedialog.client.rest.campaign.CouponOfferRest;
import com.truedialog.client.rest.campaign.ExternalCouponCodeRest;
import com.truedialog.client.rest.campaign.ExternalCouponListRest;

public class CouponDefinitionContext extends BaseContext {

    private final ExternalCouponListRest.ExternalCouponListService externalCouponListService;
    private final ExternalCouponCodeRest.ExternalCouponCodeService externalCouponCodeService;
    private final CouponOfferRest.CouponOfferService couponOfferService;
    private final CouponDefinitionRest.CouponDefinitionService couponDefinitionService;

    public CouponDefinitionContext(TrueDialogClient trueDialogClient,
                                   CouponDefinitionRest.CouponDefinitionService couponDefinitionService,
                                   CouponOfferRest.CouponOfferService couponOfferService,
                                   ExternalCouponListRest.ExternalCouponListService externalCouponListService,
                                   ExternalCouponCodeRest.ExternalCouponCodeService externalCouponCodeService) {
        super(trueDialogClient);
        this.couponDefinitionService = couponDefinitionService;
        this.couponOfferService = couponOfferService;
        this.externalCouponListService = externalCouponListService;
        this.externalCouponCodeService = externalCouponCodeService;
    }

    public CouponOfferContext getOffer() {
        return  new CouponOfferContext(trueDialogClient, this.couponOfferService);
    }

    public ExternalCouponListContext getExternalCouponList() {
        return  new ExternalCouponListContext(trueDialogClient, this.externalCouponListService);
    }

    public ExternalCouponCodeContext getExternalCouponCode() {
        return new ExternalCouponCodeContext(trueDialogClient, this.externalCouponCodeService);
    }

    public CouponDefinition getById(int campaignId) {
        return getById(trueDialogClient.getCurrentAccount(), campaignId);
    }

    public CouponDefinition getById(int campaignId, boolean throwIfEmpty) {
        return getById(trueDialogClient.getCurrentAccount(), campaignId, throwIfEmpty);
    }

    public CouponDefinition getById(int accountId, int campaignId) {
        return executeEntityCall(couponDefinitionService.getCouponDefinition(accountId, campaignId));
    }

    public CouponDefinition getById(int accountId, int campaignId, boolean throwIfEmpty) {
        return executeEntityCall(couponDefinitionService.getCouponDefinition(accountId, campaignId), throwIfEmpty);
    }

    public CouponDefinition create(int accountId, int campaignId, CouponDefinition definition) {
        return executeEntityCall(couponDefinitionService.createCouponDefinition(accountId, campaignId, definition), true);
    }

    public CouponDefinition create(int campaignId, CouponDefinition definition) {
        int accountId = definition.getAccountId() > 0 ? definition.getAccountId() : trueDialogClient.getCurrentAccount();
        return create(accountId, campaignId, definition);
    }

    public CouponDefinition create(CouponDefinition definition) {
        if (definition.getCampaignId() == 0)
            throw new IllegalArgumentException("Campaign ID is missing.");

        int accountId = definition.getAccountId() > 0 ? definition.getAccountId() : trueDialogClient.getCurrentAccount();
        return create(accountId, definition.getCampaignId(), definition);
    }

    public CouponDefinition update(int accountId, int campaignId, CouponDefinition definition) {
        return executeEntityCall(couponDefinitionService.updateCouponDefinition(accountId, campaignId, definition), true);
    }

    public CouponDefinition update(int campaignId, CouponDefinition definition) {
        int accountId = definition.getAccountId() > 0 ? definition.getAccountId() : trueDialogClient.getCurrentAccount();
        return update(accountId, campaignId, definition);
    }

    public CouponDefinition update(CouponDefinition definition) {
        if (definition.getCampaignId() == 0)
            throw new IllegalArgumentException("Campaign ID is missing.");

        int accountId = definition.getAccountId() > 0 ? definition.getAccountId() : trueDialogClient.getCurrentAccount();
        return update(accountId, definition.getCampaignId(), definition);
    }

    public CouponRedemption redeem(int accountId, String couponCode) {
        return executeEntityCall(couponDefinitionService.redeem(accountId, couponCode));
    }

    public CouponRedemption redeem(String couponCode) {
        return redeem(trueDialogClient.getCurrentAccount(), couponCode);
    }

    public CouponRedemptionDetails redemptionDetails(int accountId, int campaignId) {
        return executeEntityCall(couponDefinitionService.redemptionDetails(accountId, campaignId));
    }

    public CouponRedemptionDetails redemptionDetails(int campaignId) {
        return redemptionDetails(trueDialogClient.getCurrentAccount(), campaignId);
    }

    public CouponRedemptionDetails redemptionDetails(CouponDefinition definition) {
        if (definition.getCampaignId() == 0)
            throw new IllegalArgumentException("Campaign ID is missing.");

        int accountId = definition.getAccountId() > 0 ? definition.getAccountId() : trueDialogClient.getCurrentAccount();
        return redemptionDetails(accountId, definition.getCampaignId());
    }
}
