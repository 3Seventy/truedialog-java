package com.truedialog.client.context.campaign;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.context.content.ContentContext;
import com.truedialog.client.enums.CampaignType;
import com.truedialog.client.enums.ChannelType;
import com.truedialog.client.enums.EncodingType;
import com.truedialog.client.enums.LanguageType;
import com.truedialog.client.model.campaign.Campaign;
import com.truedialog.client.model.internal.CreateCampaign;
import com.truedialog.client.model.internal.CreateUpdateContent;
import com.truedialog.client.model.internal.CreateUpdateContentTemplate;
import com.truedialog.client.rest.campaign.*;
import com.truedialog.client.rest.content.ContentRest;
import com.truedialog.client.rest.content.ContentTemplateRest;

import java.util.ArrayList;
import java.util.List;

public class CampaignContext extends BaseContext {

    private final CouponDefinitionRest.CouponDefinitionService couponDefinitionService;
    private final CouponOfferRest.CouponOfferService couponOfferService;
    private final ExternalCouponListRest.ExternalCouponListService externalCouponListService;
    private final ExternalCouponCodeRest.ExternalCouponCodeService externalCouponCodeService;
    private final CampaignSurveyRest.CampaignSurveyService campaignSurveyService;
    private final CampaignQuestionRest.CampaignQuestionService campaignQuestionService;
    private final CampaignAnswerRest.CampaignAnswerService campaignAnswerService;
    private final ContentRest.ContentService contentService;
    private final ContentTemplateRest.ContentTemplateService contentTemplateService;
    private final LinkRest.LinkService linkService;

    private final CampaignRest.CampaignService campaignService;

    public CampaignContext(TrueDialogClient trueDialogClient,
                           CampaignRest.CampaignService campaignService,
                           CampaignSurveyRest.CampaignSurveyService campaignSurveyService,
                           CouponDefinitionRest.CouponDefinitionService couponDefinitionService,
                           CampaignQuestionRest.CampaignQuestionService campaignQuestionService,
                           CampaignAnswerRest.CampaignAnswerService campaignAnswerService,
                           CouponOfferRest.CouponOfferService couponOfferService,
                           ExternalCouponListRest.ExternalCouponListService externalCouponListService,
                           ExternalCouponCodeRest.ExternalCouponCodeService externalCouponCodeService,
                           ContentRest.ContentService contentService,
                           ContentTemplateRest.ContentTemplateService contentTemplateService,
                           LinkRest.LinkService linkService) {
        super(trueDialogClient);
        this.campaignService = campaignService;
        this.campaignSurveyService = campaignSurveyService;
        this.campaignQuestionService = campaignQuestionService;
        this.campaignAnswerService = campaignAnswerService;
        this.couponDefinitionService = couponDefinitionService;
        this.couponOfferService = couponOfferService;
        this.externalCouponListService = externalCouponListService;
        this.externalCouponCodeService = externalCouponCodeService;
        this.contentService = contentService;
        this.contentTemplateService = contentTemplateService;
        this.linkService = linkService;
    }

    public CampaignSurveyContext getSurvey() {
        return new CampaignSurveyContext(trueDialogClient, campaignSurveyService, campaignQuestionService, campaignAnswerService);
    }

    public CouponDefinitionContext getCoupon() {
        return new CouponDefinitionContext(trueDialogClient, this.couponDefinitionService, this.couponOfferService, this.externalCouponListService, this.externalCouponCodeService);
    }

    public ContentContext getContent() {
        return new ContentContext(trueDialogClient, this.contentService, this.contentTemplateService);
    }

    public LinkContext getLink() {
        return new LinkContext(trueDialogClient, this.linkService);
    }

    public List<Campaign> getList(boolean onlyMine) {
        return getList(trueDialogClient.getCurrentAccount(), onlyMine);
    }

    public List<Campaign> getList(boolean onlyMine, boolean throwIfEmpty) {
        return getList(trueDialogClient.getCurrentAccount(), onlyMine, throwIfEmpty);
    }

    public List<Campaign> getList(int accountId, boolean onlyMine) {
        return executeEntityListCall(campaignService.getCampaignList(accountId, onlyMine));
    }

    public List<Campaign> getList(int accountId, boolean onlyMine, boolean throwIfEmpty) {
        return executeEntityListCall(campaignService.getCampaignList(accountId, onlyMine), throwIfEmpty);
    }

    public Campaign getById(int campaignId) {
        return getById(trueDialogClient.getCurrentAccount(), campaignId);
    }

    public Campaign getById(int campaignId, boolean throwIfEmpty) {
        return getById(trueDialogClient.getCurrentAccount(), campaignId, throwIfEmpty);
    }

    public Campaign getById(int accountId, int campaignId) {
        return executeEntityCall(campaignService.getCampaign(accountId, campaignId));
    }

    public Campaign getById(int accountId, int campaignId, boolean throwIfEmpty) {
        return executeEntityCall(campaignService.getCampaign(accountId, campaignId), throwIfEmpty);
    }

    public Campaign create(int accountId, Campaign campaign) {
        return executeEntityCall(campaignService.createCampaign(accountId, campaign), true);
    }

    public Campaign create(Campaign campaign) {
        int accountId = campaign.getAccountId() > 0 ? campaign.getAccountId() : trueDialogClient.getCurrentAccount();
        return create(accountId, campaign);
    }

    public Campaign update(int accountId, int campaignId, Campaign campaign) {
        return executeEntityCall(campaignService.updateCampaign(accountId, campaignId, campaign), true);
    }

    public Campaign update(int campaignId, Campaign campaign) {
        int accountId = campaign.getAccountId() > 0 ? campaign.getAccountId() : trueDialogClient.getCurrentAccount();
        return update(accountId, campaignId, campaign);
    }

    public Campaign update(Campaign campaign) {
        if (campaign.getId() == 0)
            throw new IllegalArgumentException("Campaign ID is missing.");

        int accountId = campaign.getAccountId() > 0 ? campaign.getAccountId() : trueDialogClient.getCurrentAccount();
        return update(accountId, campaign.getId(), campaign);
    }

    public void delete(int accountId, int campaignId) {
        executeEntityCall(campaignService.deleteCampaign(accountId, campaignId), true);
    }

    public void delete(int campaignId) {
        delete(trueDialogClient.getCurrentAccount(), campaignId);
    }

    public void delete(Campaign campaign) {
        if (campaign.getId() == 0)
            throw new IllegalArgumentException("Campaign ID is missing.");

        int accountId = campaign.getAccountId() > 0 ? campaign.getAccountId() : trueDialogClient.getCurrentAccount();
        delete(accountId, campaign.getId());
    }

    public Campaign createGateway(int accountId, String name, int subscriptionId) {
        Campaign campaign = new Campaign();
        campaign.setName(name);
        campaign.setSubscriptionId(subscriptionId);
        campaign.setCampaignType(CampaignType.GATEWAY);
        return create(accountId, campaign);
    }

    public Campaign createGateway(int accountId, String name) {
        return createGateway(accountId, name, 0);
    }

    public Campaign createGateway(String name) {
        return createGateway(trueDialogClient.getCurrentAccount(), name, 0);
    }

    public Campaign createGateway(String name, int subscriptionId) {
        return createGateway(trueDialogClient.getCurrentAccount(), name, subscriptionId);
    }

    public Campaign createBasic(int accountId, String name, String message, int subscriptionId) {
        CreateCampaign createCampaign = new CreateCampaign();
        createCampaign.setCampaignType(CampaignType.BASIC);
        createCampaign.setName(name);
        createCampaign.setSubscriptionId(subscriptionId);

        CreateUpdateContent createUpdateContent = new CreateUpdateContent();
        createUpdateContent.setName(String.format("A%d_C%s_CONTENT", accountId, name));
        ArrayList<CreateUpdateContentTemplate> templates = new ArrayList<>();

        CreateUpdateContentTemplate createUpdateContentTemplate = new CreateUpdateContentTemplate();
        createUpdateContentTemplate.setChannelType(ChannelType.SMS);
        createUpdateContentTemplate.setEncodingType(EncodingType.RAZOR);
        createUpdateContentTemplate.setLanguageType(LanguageType.ENGLISH);
        createUpdateContentTemplate.setTemplate(message);

        templates.add(createUpdateContentTemplate);

        createUpdateContent.setTemplates(templates);

        createCampaign.setContent(createUpdateContent);

        return internalCreate(accountId, createCampaign);
    }

    public Campaign createBasic(String name, String message) {
        return createBasic(trueDialogClient.getCurrentAccount(), name, message, 0);
    }

    public Campaign createBasic(String name, String message, int subscriptionId) {
        return createBasic(trueDialogClient.getCurrentAccount(), name, message, subscriptionId);
    }

    private Campaign internalCreate(int accountId, CreateCampaign campaign) {
        return executeEntityCall(campaignService.createInternalCampaign(accountId, campaign), true);
    }
}
