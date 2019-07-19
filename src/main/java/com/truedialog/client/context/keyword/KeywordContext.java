package com.truedialog.client.context.keyword;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.campaign.Campaign;
import com.truedialog.client.model.contact.Contact;
import com.truedialog.client.model.keyword.Keyword;
import com.truedialog.client.rest.keyword.KeywordRest;

import java.util.List;

public class KeywordContext extends BaseContext {

    private KeywordRest.KeywordService keywordService;


    public KeywordContext(TrueDialogClient trueDialogClient, KeywordRest.KeywordService keywordService) {
        super(trueDialogClient);
        this.keywordService = keywordService;

    }

    public List<Keyword> getTotalList(int accountId) {
        return executeEntityListCall(keywordService.getTotalList(accountId));
    }

    public List<Keyword> getTotalList() {
        return getTotalList(trueDialogClient.getCurrentAccount());
    }

    public List<Keyword> getTotalList(int accountId, boolean throwIfEmpty) {
        return executeEntityListCall(keywordService.getTotalList(accountId), throwIfEmpty);
    }

    public List<Keyword> getTotalList(boolean throwIfEmpty) {
        return getTotalList(trueDialogClient.getCurrentAccount(), throwIfEmpty);
    }

    public List<Keyword> getList(int accountId, String channel) {
        return executeEntityListCall(keywordService.getList(accountId, channel));
    }

    public List<Keyword> getList(String channel) {
        return getList(trueDialogClient.getCurrentAccount(), channel);
    }

    public List<Keyword> getList(int accountId, String channel, boolean throwIfEmpty) {
        return executeEntityListCall(keywordService.getList(accountId, channel), throwIfEmpty);
    }

    public List<Keyword> getList(String channel, boolean throwIfEmpty) {
        return getList(trueDialogClient.getCurrentAccount(), channel, throwIfEmpty);
    }

    public Keyword getByName(int accountId, String channel, String keyword) {
        return executeEntityCall(keywordService.getKeywordByName(accountId, channel, keyword));
    }

    public Keyword getByName(String channel, String keyword) {
        return getByName(trueDialogClient.getCurrentAccount(), channel, keyword);
    }

    public Keyword getByName(int accountId, String channel, String keyword, boolean throwIfEmpty) {
        return executeEntityCall(keywordService.getKeywordByName(accountId, channel, keyword), throwIfEmpty);
    }

    public Keyword getByName(String channel, String keyword, boolean throwIfEmpty) {
        return getByName(trueDialogClient.getCurrentAccount(), channel, keyword, throwIfEmpty);
    }

    public Keyword create(int accountId, String channel, String keyword) {
        Keyword keywordObj = new Keyword();
        keywordObj.setName(keyword);
        return executeEntityCall(keywordService.create(accountId, channel, keywordObj));
    }

    public Keyword create(String channel, String keyword) {
        if (channel == null || channel.isEmpty())
            throw new IllegalArgumentException("Channel code/ID is missing.");

        return create(trueDialogClient.getCurrentAccount(), channel, keyword);
    }

    public void delete(int accountId, String channel, String keyword) {
        executeEntityCall(keywordService.delete(accountId, channel, keyword));
    }

    public void delete(String channel, String keyword) {
        delete(trueDialogClient.getCurrentAccount(), channel, keyword);
    }

    public List<Contact> getKeywordContacts(int accountId, int keywordId) {
        return executeEntityListCall(keywordService.getKeywordContacts(accountId, keywordId));
    }

    public List<Contact> getKeywordContacts(int keywordId) {
        return getKeywordContacts(trueDialogClient.getCurrentAccount(), keywordId);
    }

    public List<Contact> getKeywordContacts(int accountId, int keywordId, boolean throwIfEmpty) {
        return executeEntityListCall(keywordService.getKeywordContacts(accountId, keywordId));
    }

    public List<Contact> getKeywordContacts(int keywordId, boolean throwIfEmpty) {
        return getKeywordContacts(trueDialogClient.getCurrentAccount(), keywordId, throwIfEmpty);
    }

    public Campaign getAttachedCampaign(int accountId, String channel, String keyword) {
        return executeEntityCall(keywordService.getAttachedCampaign(accountId, channel, keyword));
    }

    public Campaign getAttachedCampaign(String channel, String keyword) {
        return getAttachedCampaign(trueDialogClient.getCurrentAccount(), channel, keyword);
    }

    public void detachCampaign(int accountId, String channel, String keyword) {
        executeEntityCall(keywordService.detachCampaign(accountId, channel, keyword));
    }

    public void detachCampaign(String channel, String keyword) {
        detachCampaign(trueDialogClient.getCurrentAccount(), channel, keyword);
    }

}
