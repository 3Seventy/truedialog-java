package com.truedialog.client.enums;

public enum DataType {
    INT_TYPE(1),
    STRING_TYPE(2),
    DOUBLE_TYPE(3),
    DATE_TYPE(4),
    BOOL_TYPE(5),
    BINARY_TYPE(6),
    GUID_TYPE(7);


    private int mDataType;

    DataType(int dataType) {
        mDataType = dataType;
    }

    public int getValue() {
        return mDataType;
    }


    public static DataType dataType(int dataType) {
        DataType type = null;

        switch (dataType) {
            case 1:
                type = INT_TYPE;
                break;
            case 2:
                type = STRING_TYPE;
                break;
            case 3:
                type = DOUBLE_TYPE;
                break;
            case 4:
                type = DATE_TYPE;
                break;
            case 5:
                type = BOOL_TYPE;
                break;
            case 6:
                type = BINARY_TYPE;
                break;

            case 7:
                type = GUID_TYPE;
                break;
        }
        return type;
    }
}
