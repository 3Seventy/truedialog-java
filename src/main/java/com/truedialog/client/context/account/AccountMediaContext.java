package com.truedialog.client.context.account;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.enums.MediaType;
import com.truedialog.client.model.account.AccountMedia;
import com.truedialog.client.rest.account.AccountMediaRest;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import java.util.Date;
import java.util.List;

public class AccountMediaContext extends BaseContext {

    private AccountMediaRest.AccountMediaService accountMediaService;


    public AccountMediaContext(TrueDialogClient trueDialogClient, AccountMediaRest.AccountMediaService accountMediaService) {
        super(trueDialogClient);
        this.accountMediaService = accountMediaService;
    }


    public List<AccountMedia> getList(int accountId) {
        return executeEntityCall(accountMediaService.getAccountMediaList(accountId));

    }

    public List<AccountMedia> getList(int accountId, boolean throwIfEmpty) {
        return executeEntityCall(accountMediaService.getAccountMediaList(accountId), throwIfEmpty);

    }

    public List<AccountMedia> getList() {
        return getList(trueDialogClient.getCurrentAccount());
    }

    public List<AccountMedia> getList(boolean throwIfEmpty) {
        return getList(trueDialogClient.getCurrentAccount(), throwIfEmpty);
    }


    public AccountMedia getById(int accountId, int imageId) {
        return executeEntityCall(accountMediaService.getAccountMediaById(accountId, imageId));
    }

    public AccountMedia getById(int imageId) {
        return getById(trueDialogClient.getCurrentAccount(), imageId);
    }

    public AccountMedia getById(int accountId, int imageId, boolean throwIfEmpty) {
        return executeEntityCall(accountMediaService.getAccountMediaById(accountId, imageId), throwIfEmpty);
    }

    public AccountMedia getById(int imageId, boolean throwIfEmpty) {
        return getById(trueDialogClient.getCurrentAccount(), imageId, throwIfEmpty);
    }

    public void delete(int accountId, int imageId) {
        executeEntityCall(accountMediaService.deleteAccountMedia(accountId, imageId));
    }

    public void delete(int imageId) {
        delete(trueDialogClient.getCurrentAccount(), imageId);
    }

    public void delete(AccountMedia accountMedia) {
        delete(accountMedia.getAccountId(), accountMedia.getId());
    }


    public AccountMedia uploadAsByteArray( MediaType type, byte[] byteArray) {
        String extension = extensionFromMimeType(type);
        int accountId = trueDialogClient.getCurrentAccount();
        String fileName = String.format("ACCT%s_%s_Media%s", accountId, new Date().getTime(), extension);
        MultipartBody.Part filePart = MultipartBody.Part.createFormData(fileName, fileName, RequestBody.create(okhttp3.MediaType.parse("image/*"), byteArray));

        return executeEntityListCall(accountMediaService.uploadAsByteArray(accountId, filePart)).get(0);
    }

    public AccountMedia uploadAsByteArray(int accountId, MediaType type, byte[] byteArray) {
        String extension = extensionFromMimeType(type);
        String fileName = String.format("ACCT%s_%s_Media%s", accountId, new Date().getTime(), extension);
        MultipartBody.Part filePart = MultipartBody.Part.createFormData(fileName, fileName, RequestBody.create(okhttp3.MediaType.parse("image/*"), byteArray));

        return executeEntityListCall(accountMediaService.uploadAsByteArray(accountId, filePart)).get(0);
    }


    public AccountMedia uploadAsBase64(String base64String) {
        String extension = extensionFromMimeType(base64String);
        int accountId = trueDialogClient.getCurrentAccount();
        String fileName = String.format("ACCT%s_%s_Media%s", accountId, new Date().getTime(), extension);
        MultipartBody.Part filePart = MultipartBody.Part.createFormData(fileName, fileName, RequestBody.create(okhttp3.MediaType.parse("image/*"), bytesFromBase64String(base64String)));

        return executeEntityListCall(accountMediaService.uploadAsByteArray(accountId, filePart)).get(0);
    }

    public AccountMedia uploadAsBase64(int accountId, String base64String) {
        String extension = extensionFromMimeType(base64String);
        String fileName = String.format("ACCT%s_%s_Media%s", accountId, new Date().getTime(), extension);
        MultipartBody.Part filePart = MultipartBody.Part.createFormData(fileName, fileName, RequestBody.create(okhttp3.MediaType.parse("image/*"), bytesFromBase64String(base64String)));

        return executeEntityListCall(accountMediaService.uploadAsByteArray(accountId, filePart)).get(0);
    }


    private byte[] bytesFromBase64String(String base64string) {
        int index = base64string.indexOf(";base64,");
        if (index < 0) {
            return null;
        }
        String base64clean = base64string.substring(index + ";base64,".length());

        return base64clean.getBytes();

    }

    private String extensionFromMimeType(MediaType type) {
        switch (type) {
            case IMAGE_GIF:
                return ".gif";
            case IMAGE_PNG:
                return ".png";
            case IMAGE_JPG:
                return ".jpg";
        }
        return "";
    }

    private String extensionFromMimeType(String imageString) {

        int startIndex = imageString.indexOf("data:") + "data:".length();
        int length = imageString.indexOf(";base64,") - startIndex;
        String mimeType = imageString.substring(startIndex, length);

        switch (mimeType) {
            case "image/jpeg":
                return ".jpg";
            case "image/gif":
                return ".gif";
            case "image/png":
                return ".png";
            default:
                throw new IllegalArgumentException(String.format("%s is not supported MIME type", mimeType));
        }

    }
}
