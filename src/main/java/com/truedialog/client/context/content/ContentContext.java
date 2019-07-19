package com.truedialog.client.context.content;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.content.Content;
import com.truedialog.client.rest.content.ContentRest;
import com.truedialog.client.rest.content.ContentTemplateRest;

import java.util.List;

public class ContentContext extends BaseContext {

    private ContentRest.ContentService contentService;
    private ContentTemplateContext template;

    public ContentContext(TrueDialogClient trueDialogClient, ContentRest.ContentService contentService, ContentTemplateRest.ContentTemplateService contentTemplateService) {
        super(trueDialogClient);
        this.contentService = contentService;
        this.template = new ContentTemplateContext(trueDialogClient, contentTemplateService);
    }

    public ContentTemplateContext getTemplate() {
        return template;
    }

    public List<Content> getList() {
        return getList(trueDialogClient.getCurrentAccount());
    }

    public List<Content> getList(boolean throwIfEmpty) {
        return getList(trueDialogClient.getCurrentAccount(), throwIfEmpty);
    }

    public List<Content> getList(int accountId) {
        return executeEntityListCall(contentService.getContentList(accountId));
    }

    public List<Content> getList(int accountId, boolean throwIfEmpty) {
        return executeEntityListCall(contentService.getContentList(accountId), throwIfEmpty);
    }

    public Content GetById(int contentId) {
        return GetById(trueDialogClient.getCurrentAccount(), contentId);
    }

    public Content GetById(int contentId, boolean throwIfEmpty) {
        return GetById(trueDialogClient.getCurrentAccount(), contentId, throwIfEmpty);
    }

    public Content GetById(int accountId, int contentId) {
        return executeEntityCall(contentService.getContent(accountId, contentId));
    }

    public Content GetById(int accountId, int contentId, boolean throwIfEmpty) {
        return executeEntityCall(contentService.getContent(accountId, contentId), throwIfEmpty);
    }

    public Content create(int accountId, Content content) {
        return executeEntityCall(contentService.createContent(accountId, content), true);
    }

    public Content create(Content content) {
        return create(trueDialogClient.getCurrentAccount(), content);
    }

    public Content update(int accountId, int contentId, Content content) {
        return executeEntityCall(contentService.updateContent(accountId, contentId, content), true);
    }

    public Content update(int contentId, Content content) {
        int accountId = content.getAccountId() > 0 ? content.getAccountId() : trueDialogClient.getCurrentAccount();
        return update(accountId, contentId, content);
    }

    public Content update(Content content) {
        if (content.getId() == 0)
            throw new IllegalArgumentException("Content ID is missing.");

        int accountId = content.getAccountId() > 0 ? content.getAccountId() : trueDialogClient.getCurrentAccount();
        return update(accountId, content.getId(), content);
    }

    public void delete(int accountId, int contentId) {
        executeEntityCall(contentService.deleteContent(accountId, contentId), true);
    }

    public void delete(int contentId) {
        delete(trueDialogClient.getCurrentAccount(), contentId);
    }

    public void delete(Content content) {
        if (content.getId() == 0)
            throw new IllegalArgumentException("Content ID is missing.");

        int accountId = content.getAccountId() > 0 ? content.getAccountId() : trueDialogClient.getCurrentAccount();
        delete(accountId, content.getId());
    }
}
