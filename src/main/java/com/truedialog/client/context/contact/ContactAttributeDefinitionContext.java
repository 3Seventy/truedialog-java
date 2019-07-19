package com.truedialog.client.context.contact;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.contact.ContactAttributeDefinition;
import com.truedialog.client.rest.contact.ContactAttributeDefinitionRest;
import com.truedialog.client.rest.contact.ContactRest;

import java.util.List;

public class ContactAttributeDefinitionContext extends BaseContext {

    private ContactAttributeDefinitionRest.ContactAttributeDefinitionService contactAttributeDefinitionService;


    ContactAttributeDefinitionContext(TrueDialogClient trueDialogClient, ContactAttributeDefinitionRest.ContactAttributeDefinitionService contactAttributeDefinitionService) {
        super(trueDialogClient);
        this.contactAttributeDefinitionService = contactAttributeDefinitionService;
    }

    public ContactAttributeDefinition getById(int definitionId) {
        return getById(trueDialogClient.getCurrentAccount(), definitionId);
    }

    public ContactAttributeDefinition getById(int definitionId, boolean throwIfEmpty) {
        return getById(trueDialogClient.getCurrentAccount(), definitionId, throwIfEmpty);

    }

    public ContactAttributeDefinition getById(int accountId, int definitionId) {
        return executeEntityCall(contactAttributeDefinitionService.getContactAttributeDefinitionById(accountId, definitionId));

    }

    public ContactAttributeDefinition getById(int accountId, int definitionId, boolean throwIfEmpty) {
        return executeEntityCall(contactAttributeDefinitionService.getContactAttributeDefinitionById(accountId, definitionId), throwIfEmpty);

    }

    public List<ContactAttributeDefinition> getList() {
        return getList(trueDialogClient.getCurrentAccount());
    }

    public List<ContactAttributeDefinition> getList(boolean throwIfEmpty) {
        return getList(trueDialogClient.getCurrentAccount(), throwIfEmpty);

    }

    public List<ContactAttributeDefinition> getList(int accountId) {
        return executeEntityListCall(contactAttributeDefinitionService.getContactAttributeDefinitionContextList(accountId));

    }

    public List<ContactAttributeDefinition> getList(int accountId, boolean throwIfEmpty) {
        return executeEntityListCall(contactAttributeDefinitionService.getContactAttributeDefinitionContextList(accountId), throwIfEmpty);

    }

    public ContactAttributeDefinition updateDescription(int accountId, int definitionId, String description) {
        return executeEntityCall(contactAttributeDefinitionService.updateContactAttributeDefinition(accountId, definitionId, description));
    }

    public ContactAttributeDefinition updateDescription(int definitionId, String description) {
        return executeEntityCall(contactAttributeDefinitionService.updateContactAttributeDefinition(trueDialogClient.getCurrentAccount(), definitionId, description));
    }

    public void delete(int accountId, int definitionId) {
        executeEntityCall(contactAttributeDefinitionService.delete(accountId, definitionId));
    }

    public void delete(int definitionId) {
        executeEntityCall(contactAttributeDefinitionService.delete(trueDialogClient.getCurrentAccount(), definitionId));
    }

    public void delete(ContactAttributeDefinition contactAttributeDefinition) {
        if (contactAttributeDefinition.getId() == 0) {
            throw new IllegalArgumentException("Definition ID is missing.");
        }
        int accountId = contactAttributeDefinition.getAccountId() > 0 ? contactAttributeDefinition.getAccountId() : trueDialogClient.getCurrentAccount();
        delete(accountId, contactAttributeDefinition.getId());
    }


}
