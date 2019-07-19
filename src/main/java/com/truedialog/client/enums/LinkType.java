package com.truedialog.client.enums;

/**
 * Link processing type
 */
public enum LinkType {

    /**
     * Links are static and don't have any dynamic properties.
     */
    STATIC(0),

    /**
     * Links contain some dynamic properties.
     */
    DYNAMIC(1);


    int value;

    LinkType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static LinkType linkType(int linkType) {
        LinkType type = null;

        switch (linkType) {
            case 0:
                type = STATIC;
                break;
            case 1:
                type = DYNAMIC;
                break;
        }

        return type;
    }
}
