package com.truedialog.client.enums;

/**
 * Different Action Types
 */
public enum ActionType {
    /**
     * This Action type lets you Attach a keyword to a Campaign
     */
    ATTACH_KEYWORD(1),

    /**
     * This Action Type lets you send an SMS
     */
    SEND_SMS(2),

    /**
     * This Action Type lets you push a campaign to a contact ot a list of contacts usign a contact list
     */
    PUSH_CAMPAIGN(3),

    /**
     * This Action Type triggers a Callback on a Dialog Campaign
     */
    DIALOG_CALLBACK(4),

    /**
     * This Action Type triggers a callback when a contact Text in STOP
     */
    STOP_CALLBACK(5),

    /**
     * This Action Type triggers a callback when a contact Text in a Keyword
     */
    KEYWORD_CALLBACK(6),

    /**
     * This Action Type triggers a callback on an new account signup via chargify
     */
    CHARGIFY_CALLBACK(7),

    /**
     * This Action Type triggers a callback on an account creation
     */
    NEW_ACCOUNT_CALLBACK(8),

    /**
     * This Action Type lets you import list of contacts into the system from a CSV file.
     */
    IMPORT_CONTACTS(13),

    /**
     * This Action Type lets you Kill a push campaign if its not yet triggered
     */
    KILL_CAMPAIGN_PUSH(14);

    private int value;

    ActionType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ActionType actionType(int value) {
        switch (value) {
            case 1:
                return ATTACH_KEYWORD;
            case 2:
                return SEND_SMS;
            case 3:
                return PUSH_CAMPAIGN;
            case 4:
                return DIALOG_CALLBACK;
            case 5:
                return STOP_CALLBACK;
            case 6:
                return KEYWORD_CALLBACK;
            case 7:
                return CHARGIFY_CALLBACK;
            case 8:
                return NEW_ACCOUNT_CALLBACK;
            case 13:
                return IMPORT_CONTACTS;
            case 14:
                return KILL_CAMPAIGN_PUSH;

        }
        return null;
    }
}