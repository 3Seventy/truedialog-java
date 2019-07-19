package com.truedialog.client.context.content;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.content.ContentTemplate;
import com.truedialog.client.rest.content.ContentTemplateRest;

import java.util.List;

public class ContentTemplateContext extends BaseContext {

    private ContentTemplateRest.ContentTemplateService contentTemplateService;

    public ContentTemplateContext(TrueDialogClient trueDialogClient, ContentTemplateRest.ContentTemplateService contentTemplateService) {
        super(trueDialogClient);
        this.contentTemplateService = contentTemplateService;
    }

    public List<ContentTemplate> getList(int contentId) {
        return getList(trueDialogClient.getCurrentAccount(), contentId);
    }

    public List<ContentTemplate> getList(int contentId, boolean throwIfEmpty) {
        return getList(trueDialogClient.getCurrentAccount(), contentId, throwIfEmpty);
    }

    public List<ContentTemplate> getList(int accountId, int contentId) {
        return executeEntityListCall(contentTemplateService.getContentTemplateList(accountId, contentId));
    }

    public List<ContentTemplate> getList(int accountId, int contentId, boolean throwIfEmpty) {
        return executeEntityListCall(contentTemplateService.getContentTemplateList(accountId, contentId), throwIfEmpty);
    }

    public ContentTemplate getById(int contentId, int templateId) {
        return getById(trueDialogClient.getCurrentAccount(), contentId, templateId);
    }

    public ContentTemplate getById(int contentId, int templateId, boolean throwIfEmpty) {
        return getById(trueDialogClient.getCurrentAccount(), contentId, templateId, throwIfEmpty);
    }

    public ContentTemplate getById(int accountId, int contentId, int templateId) {
        return executeEntityCall(contentTemplateService.getContentTemplate(accountId, contentId, templateId));
    }

    public ContentTemplate getById(int accountId, int contentId, int templateId, boolean throwIfEmpty) {
        return executeEntityCall(contentTemplateService.getContentTemplate(accountId, contentId, templateId), throwIfEmpty);
    }

    public ContentTemplate create(int accountId, int contentId, ContentTemplate template) {
        return executeEntityCall(contentTemplateService.createContentTemplate(accountId, contentId, template), true);
    }

    public ContentTemplate create(int contentId, ContentTemplate template) {
        int accountId = template.getAccountId() > 0 ? template.getAccountId() : trueDialogClient.getCurrentAccount();
        return create(accountId, contentId, template);
    }

    public ContentTemplate create(ContentTemplate template) {
        if (template.getContentId() == 0)
            throw new IllegalArgumentException("Content ID is missing.");

        int accountId = template.getAccountId() > 0 ? template.getAccountId() : trueDialogClient.getCurrentAccount();
        return create(accountId, template.getContentId(), template);
    }

    public ContentTemplate update(int accountId, int contentId, int templateId, ContentTemplate template) {
        return executeEntityCall(contentTemplateService.updateContentTemplate(accountId, contentId, templateId, template), true);
    }

    public ContentTemplate update(int contentId, int templateId, ContentTemplate template) {
        int accountId = template.getAccountId() > 0 ? template.getAccountId() : trueDialogClient.getCurrentAccount();
        return update(accountId, contentId, templateId, template);
    }

    public ContentTemplate update(ContentTemplate template) {
        if (template.getId() == 0)
            throw new IllegalArgumentException("Template ID is missing");
        if (template.getContentId() == 0)
            throw new IllegalArgumentException("Content ID is missing.");

        int accountId = template.getAccountId() > 0 ? template.getAccountId() : trueDialogClient.getCurrentAccount();
        return update(accountId, template.getId(), template.getContentId(), template);
    }

    public void delete(int accountId, int contentId, int templateId) {
        executeEntityCall(contentTemplateService.deleteContentTemplate(accountId, contentId, templateId), true);
    }

    public void delete(int contentId, int templateId) {
        delete(trueDialogClient.getCurrentAccount(), contentId, templateId);
    }

    public void delete(ContentTemplate template) {
        if (template.getId() == 0)
            throw new IllegalArgumentException("Template ID is missing");
        if (template.getContentId() == 0)
            throw new IllegalArgumentException("Content ID is missing.");

        int accountId = template.getAccountId() > 0 ? template.getAccountId() : trueDialogClient.getCurrentAccount();

        delete(accountId, template.getContentId(), template.getId());
    }
}
