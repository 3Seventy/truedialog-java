package com.truedialog.client;


import com.truedialog.client.config.AuthConfig;
import com.truedialog.client.config.TrueDialogConfig;
import com.truedialog.client.context.account.AccountContext;
import com.truedialog.client.context.account.AccountMediaContext;
import com.truedialog.client.context.account.ApiKeyContext;
import com.truedialog.client.context.action.ImportContext;
import com.truedialog.client.context.action.ScheduleContext;
import com.truedialog.client.context.callback.CallbackContext;
import com.truedialog.client.context.campaign.CampaignContext;
import com.truedialog.client.context.channel.ChannelContext;
import com.truedialog.client.context.contact.ContactContext;
import com.truedialog.client.context.content.ContentContext;
import com.truedialog.client.context.keyword.KeywordContext;
import com.truedialog.client.context.message.MessageContext;
import com.truedialog.client.context.report.ReportContext;
import com.truedialog.client.context.subscription.SubscriptionContext;
import com.truedialog.client.context.user.UserContext;
import com.truedialog.client.rest.RestClient;
import com.truedialog.client.rest.account.AccountAttributeRest;
import com.truedialog.client.rest.account.AccountMediaRest;
import com.truedialog.client.rest.account.AccountRest;
import com.truedialog.client.rest.action.ImportRest;
import com.truedialog.client.rest.action.ScheduleRest;
import com.truedialog.client.rest.callback.CallbackRest;
import com.truedialog.client.rest.account.ApiKeyRest;
import com.truedialog.client.rest.campaign.*;
import com.truedialog.client.rest.channel.ChannelRest;
import com.truedialog.client.rest.channel.LongCodeRest;
import com.truedialog.client.rest.contact.ContactAttributeDefinitionRest;
import com.truedialog.client.rest.contact.ContactAttributeRest;
import com.truedialog.client.rest.contact.ContactRest;
import com.truedialog.client.rest.contact.ContactSubscriptionRest;
import com.truedialog.client.rest.content.ContentRest;
import com.truedialog.client.rest.content.ContentTemplateRest;
import com.truedialog.client.rest.keyword.KeywordRest;
import com.truedialog.client.rest.message.MessageRest;
import com.truedialog.client.rest.report.CampaignReportRest;
import com.truedialog.client.rest.report.MessageReportRest;
import com.truedialog.client.rest.subscription.SubscriptionRest;
import com.truedialog.client.rest.user.UserRest;

public class TrueDialogClient {

    //TODO remove
    private static final String USER_NAME = "Integraton_User_1";
    private static final String PASSwORD = "Pivot123!";

    private int accountId;
    private Integer withAccountId = null;
    private RestClient restClient;

    public TrueDialogClient() {
        initClient();
    }

    public TrueDialogClient(int accountId) {
        this.accountId = accountId;
        initClient();
    }

    private void initClient() {

        restClient = RestClient.fromClientConfig(
                // TrueDialogConfig.fromConfigFile()
                new TrueDialogConfig.TrueDialogClientConfigBuilder(new AuthConfig(USER_NAME, PASSwORD))
                        .build()
        );

        if (accountId <= 0) {
            throw new IllegalStateException("AccountId must be specified in config file, or passed as constructor parameter.");
        }
    }

    public int getAccountId() {
        return accountId;
    }

    public int getCurrentAccount() {
        int id = withAccountId != null ? withAccountId : accountId;
        withAccountId = null;
        return id;
    }

    public TrueDialogClient withAccount(int accountId) {
        withAccountId = accountId;
        return this;
    }


    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public AccountContext getAccount() {
        return new AccountContext(this,
                restClient.getService(AccountRest.AccountService.class),
                restClient.getService(AccountAttributeRest.AccountAttributeService.class));
    }

    public AccountMediaContext getMedia(){
        return new AccountMediaContext(this, restClient.getService(AccountMediaRest.AccountMediaService.class));
    }

    public ImportContext getImport() {
        return new ImportContext(this, restClient.getService(ImportRest.ImportService.class));
    }

    public ScheduleContext getSchedule() {
        return new ScheduleContext(this, restClient.getService(ScheduleRest.ScheduleService.class));
    }

    public MessageContext getMessage() {
        return new MessageContext(this, restClient.getService(MessageRest.MessageService.class));
    }

    public UserContext getUser() {
        return new UserContext(this, restClient.getService(UserRest.UserService.class));
    }

    public SubscriptionContext getSubscription() {
        return new SubscriptionContext(this, restClient.getService(SubscriptionRest.SubscriptionService.class));
    }

    public ContactContext getContact() {
        return new ContactContext(this,
                restClient.getService(ContactRest.ContactService.class),
                restClient.getService(ContactAttributeRest.ContactAttributeService.class),
                restClient.getService(ContactAttributeDefinitionRest.ContactAttributeDefinitionService.class),
                restClient.getService(ContactSubscriptionRest.ContactSubscriptionService.class));
    }

    public CampaignContext getCampaign() {
        return new CampaignContext(this,
                restClient.getService(CampaignRest.CampaignService.class),
                restClient.getService(CampaignSurveyRest.CampaignSurveyService.class),
                restClient.getService(CouponDefinitionRest.CouponDefinitionService.class),
                restClient.getService(CampaignQuestionRest.CampaignQuestionService.class),
                restClient.getService(CampaignAnswerRest.CampaignAnswerService.class),
                restClient.getService(CouponOfferRest.CouponOfferService.class),
                restClient.getService(ExternalCouponListRest.ExternalCouponListService.class),
                restClient.getService(ExternalCouponCodeRest.ExternalCouponCodeService.class),
                restClient.getService(ContentRest.ContentService.class),
                restClient.getService(ContentTemplateRest.ContentTemplateService.class),
                restClient.getService(LinkRest.LinkService.class));
    }

    public KeywordContext getKeyword() {
        return new KeywordContext(this, restClient.getService(KeywordRest.KeywordService.class));
    }

    public ChannelContext getChannel() {
        return new ChannelContext(this,
                restClient.getService(ChannelRest.ChannelService.class),
                restClient.getService(LongCodeRest.LongCodeService.class));
    }

    public CallbackContext getCallback() {
        return new CallbackContext(this, restClient.getService(CallbackRest.CallbackService.class));
    }

    public ApiKeyContext getApiKey() {
        return new ApiKeyContext(this, restClient.getService(ApiKeyRest.ApiKeyService.class));
    }

    public ContentContext getContent() {
        return new ContentContext(this,
                restClient.getService(ContentRest.ContentService.class),
                restClient.getService(ContentTemplateRest.ContentTemplateService.class));
    }

    public ReportContext getReport() {
        return new ReportContext(this,
                restClient.getService(CampaignReportRest.CampaignReportService.class),
                restClient.getService(MessageReportRest.MessageReportService.class));
    }

}
