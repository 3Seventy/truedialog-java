package com.truedialog.client.context.user;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.user.User;
import com.truedialog.client.model.user.UserPassword;
import com.truedialog.client.rest.user.UserRest;

import java.util.List;

public class UserContext extends BaseContext {

    private UserRest.UserService service;

    public UserContext(TrueDialogClient trueDialogClient, UserRest.UserService service) {
        super(trueDialogClient);
        this.service = service;
    }

    /*
        Get List
     */
    public List<User> getList() {
        return getList(trueDialogClient.getCurrentAccount());
    }

    public List<User> getList(boolean throwIfEmpty) {
        return getList(trueDialogClient.getCurrentAccount(), throwIfEmpty);
    }

    public List<User> getList(int accountId) {
        return executeEntityListCall(service.getUserList(accountId));
    }

    public List<User> getList(int accountId, boolean throwIfEmpty) {
        return executeEntityListCall(service.getUserList(accountId), throwIfEmpty);
    }

    /*
        Get User
     */
    public User getUser(String username) {
        return getUser(trueDialogClient.getCurrentAccount(), username);
    }

    public User getUser(String username, boolean throwIfEmpty) {
        return getUser(trueDialogClient.getCurrentAccount(), username, throwIfEmpty);
    }

    public User getUser(int accountId, String username) {
        return executeEntityCall(service.getUserItem(accountId, username));
    }

    public User getUser(int accountId, String username, boolean throwIfEmpty) {
        return executeEntityCall(service.getUserItem(accountId, username), throwIfEmpty);
    }

    /*
        Create User
     */
    public User create(User user) {
        return create(user.getAccountId() > 0 ? user.getAccountId() : trueDialogClient.getCurrentAccount(), user);
    }

    public User create(int accountId, User user) {
        return executeEntityCall(service.createUser(accountId, user), true);
    }

    /*
        Delete User
     */
    public void delete(String username) {
        delete(trueDialogClient.getCurrentAccount(), username);
    }

    public void delete(int accountId, String username) {
        executeEntityCall(service.deleteUser(accountId, username), true);
    }

    /*
        Update User
     */
    public User update(User user) {
        return update(user.getAccountId(), user.getUserName(), user);
    }

    public User update(int accountId, String username, User user) {
        return executeEntityCall(service.updateUser(accountId, username, user), true);
    }

    /*
        Lock User
     */
    public void lock(String username) {
        lock(trueDialogClient.getCurrentAccount(), username);
    }

    public void lock(int accountId, String username) {
        executeEntityCall(service.lockUser(accountId, username), true);
    }

    public void lock(User user) {
        lock(user.getAccountId(), user.getUserName());
    }

    /*
        Unlock User
     */
    public void unlock(String username) {
        unlock(trueDialogClient.getCurrentAccount(), username);
    }

    public void unlock(int accountId, String username) {
        executeEntityCall(service.unlockUser(accountId, username), true);
    }

    public void unlock(User user) {
        unlock(user.getAccountId(), user.getUserName());
    }


    /*
        Update Password
    */
    public void updatePassword(String username, UserPassword userPassword) {
        updatePassword(trueDialogClient.getCurrentAccount(), username, userPassword);
    }

    public void updatePassword(int accountId, String username, UserPassword userPassword) {
        executeEntityCall(service.updatePassword(accountId, username, userPassword), true);
    }


}
