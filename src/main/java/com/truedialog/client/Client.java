package com.truedialog.client;

public class Client {
    private Client() {
    }

    private static volatile TrueDialogClient instance;

    public static TrueDialogClient getInstance() {
        TrueDialogClient localInstance = instance;
        if (localInstance == null) {
            synchronized (TrueDialogClient.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new TrueDialogClient();
                }
            }
        }
        return localInstance;
    }
}