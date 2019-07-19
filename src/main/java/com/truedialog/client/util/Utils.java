package com.truedialog.client.util;

public class Utils {

    public static String readPhoneNumber(String phoneNumber) {
        String rval = removeSpecialCharacters(phoneNumber);

        if (rval.charAt(0) == '1' && rval.length() == 11)
            rval = "+" + rval;
        else if (rval.charAt(0) != '1' && rval.length() == 10)
            rval = "+1" + rval;
        else
            throw new IllegalArgumentException("Wrong phone number format. Please follow E.164 format (+1xxxxxxxxxx).");

        return rval;
    }

    public static String removeSpecialCharacters(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()
        ) {
            if (c >= '0' && c <= '9') {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static String softReadPhoneNumber(String phoneNumber) {
        String rval = removeSpecialCharacters(phoneNumber);

        if (rval.charAt(0) == '1' && rval.length() == 11)
            return rval;
        else if (rval.charAt(0) != '1' && rval.length() == 10)
            rval = "1" + rval;
        else
            throw new IllegalArgumentException("Wrong phone number format. Please follow E.164 format (+1xxxxxxxxxx).");

        return rval;
    }
}
