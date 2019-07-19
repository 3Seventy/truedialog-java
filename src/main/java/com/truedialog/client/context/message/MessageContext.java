package com.truedialog.client.context.message;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.action.ActionPushCampaign;
import com.truedialog.client.rest.message.MessageRest;

import java.util.ArrayList;
import java.util.Collections;

public class MessageContext extends BaseContext {

    private MessageRest.MessageService service;

    public MessageContext(TrueDialogClient trueDialogClient, MessageRest.MessageService service) {
        super(trueDialogClient);
        this.service = service;
    }

    public ActionPushCampaign submit(ActionPushCampaign actionPushCampaign) {
        return submit(trueDialogClient.getCurrentAccount(), actionPushCampaign);
    }

    public ActionPushCampaign submit(int accountId, ActionPushCampaign actionPushCampaign) {
        return executeEntityCall(service.submit(accountId, actionPushCampaign), true);
    }

    public ActionPushCampaign sendBasic(int accountId, String from, String to, String message) {
        ActionPushCampaign actionPushCampaign = new ActionPushCampaign();

        actionPushCampaign.setChannels(new ArrayList<>(Collections.singletonList(from)));
        actionPushCampaign.setTargets(new ArrayList<>(Collections.singletonList(to)));
        actionPushCampaign.setMessage(message);
        actionPushCampaign.setExecute(true);

        return submit(accountId, actionPushCampaign);
    }

    public ActionPushCampaign sendBasic(String from, String to, String message) {
        ActionPushCampaign actionPushCampaign = new ActionPushCampaign();

        actionPushCampaign.setChannels(new ArrayList<>(Collections.singletonList(from)));
        actionPushCampaign.setTargets(new ArrayList<>(Collections.singletonList(to)));
        actionPushCampaign.setMessage(message);
        actionPushCampaign.setExecute(true);

        return submit(trueDialogClient.getCurrentAccount(), actionPushCampaign);
    }

}
