package com.truedialog.client.enums;


public enum Operand {

    /**
     * Filter contacts by subscription ID
     * <remarks>
     * Can be used with "Subscription" FilterType only.
     * </remarks>
     */
    SUBSCRIPTION_ID(1),

    /**
     * Filter contacts by the date of creation.
     * <remarks>
     * Can be used with "Contact" FilterType only.
     * </remarks>
     */
    CREATED(2),

    /**
     * Filter contacts by contact ID.
     * <remarks>
     * Can be used with "Contact" FilterType only.
     * </remarks>
     */
    ID(3),

    /**
     * Filter contacts by contact's Email field.
     * <remarks>
     * Can be used with "Contact" FilterType only.
     * </remarks>
     */
    EMAIL(4),

    /**
     * Filter contacts by contact's PhoneNumber field.
     * <remarks>
     * Can be used with "Contact" FilterType only.
     * </remarks>
     */
    PHONE(5),

    /**
     * Filter contacts by keyword ID
     * <remarks>
     * Can be used with "Keyword" FilterType only.
     * </remarks>
     */
    CONTACT_BY_KEYWORD(6),

    /**
     * Filter contacts by keyword send date.
     * <remarks>
     * Can be used with "Keyword" FilterType only.
     * </remarks>
     */
    KEYWORD_SENT_DATE(7);

    private int value;

    Operand(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Operand operand(int operand) {
        switch (operand) {
            case 1:
                return SUBSCRIPTION_ID;
            case 2:
                return CREATED;
            case 3:
                return ID;
            case 4:
                return EMAIL;
            case 5:
                return PHONE;
            case 6:
                return CONTACT_BY_KEYWORD;
            case 7:
                return KEYWORD_SENT_DATE;
            default:
                return null;

        }
    }
}
