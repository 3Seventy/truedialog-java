package com.truedialog.client.context.campaign;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.campaign.Link;
import com.truedialog.client.rest.campaign.LinkRest;

import java.util.List;

public class LinkContext extends BaseContext {

    private LinkRest.LinkService linkService;

    public LinkContext(TrueDialogClient trueDialogClient, LinkRest.LinkService linkService) {
        super(trueDialogClient);
        this.linkService = linkService;
    }

    public List<Link> getList() {
        return getList(trueDialogClient.getCurrentAccount());
    }

    public List<Link> getList(boolean throwIfEmpty) {
        return getList(trueDialogClient.getCurrentAccount(), throwIfEmpty);
    }

    public List<Link> getList(int accountId) {
        return executeEntityListCall(linkService.getLinkList(accountId));
    }

    public List<Link> getList(int accountId, boolean throwIfEmpty) {
        return executeEntityListCall(linkService.getLinkList(accountId), throwIfEmpty);
    }

    public Link getById(int linkId) {
        return getById(trueDialogClient.getCurrentAccount(), linkId);
    }

    public Link getById(int linkId, boolean throwIfEmpty) {
        return getById(trueDialogClient.getCurrentAccount(), linkId, throwIfEmpty);
    }

    public Link getById(int accountId, int linkId) {
        return executeEntityCall(linkService.getLink(accountId, linkId));
    }

    public Link getById(int accountId, int linkId, boolean throwIfEmpty) {
        return executeEntityCall(linkService.getLink(accountId, linkId), throwIfEmpty);
    }

    public Link create(int accountId, Link link) {
        return executeEntityCall(linkService.createLink(accountId, link), true);
    }

    public Link create(Link link) {
        int accountId = link.getAccountId() > 0 ? link.getAccountId() : trueDialogClient.getCurrentAccount();
        return create(accountId, link);
    }

    public Link update(int accountId, int linkId, Link link) {
        return executeEntityCall(linkService.updateLink(accountId, linkId, link), true);
    }

    public Link update(int linkId, Link link) {
        return update(trueDialogClient.getCurrentAccount(), linkId, link);
    }

    public Link update(Link link) {
        if (link.getId() == 0)
            throw new IllegalArgumentException("Link ID is missing.");

        int accountId = link.getAccountId() > 0 ? link.getAccountId() : trueDialogClient.getCurrentAccount();
        return update(accountId, link.getId(), link);
    }

    public void delete(int accountId, int linkId) {
        executeEntityCall(linkService.deleteLink(accountId, linkId), true);
    }

    public void delete(int linkId) {
        delete(trueDialogClient.getCurrentAccount(), linkId);
    }

    public void delete(Link link) {
        if (link.getId() == 0)
            throw new IllegalArgumentException("Link ID is missing.");

        int accountId = link.getAccountId() > 0 ? link.getAccountId() : trueDialogClient.getCurrentAccount();
        delete(accountId, link.getId());
    }
}
