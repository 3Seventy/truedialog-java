package com.truedialog.client.context.channel;

import com.truedialog.client.TrueDialogClient;
import com.truedialog.client.context.BaseContext;
import com.truedialog.client.model.channel.Channel;
import com.truedialog.client.rest.channel.ChannelRest;
import com.truedialog.client.rest.channel.LongCodeRest;

import java.util.List;

public class ChannelContext extends BaseContext {

    private final LongCodeRest.LongCodeService longCodeService;
    private final ChannelRest.ChannelService channelService;


    public ChannelContext(TrueDialogClient trueDialogClient,
                          ChannelRest.ChannelService channelService,
                          LongCodeRest.LongCodeService longCodeService) {
        super(trueDialogClient);
        this.channelService = channelService;
        this.longCodeService = longCodeService;
    }

    public LongCodeContext getLongCodeContext() {
        return new LongCodeContext(trueDialogClient, this.longCodeService);
    }

    public List<Channel> getList() {
        return getList(trueDialogClient.getCurrentAccount());
    }

    public List<Channel> getList(boolean throwIfEmpty) {
      return   getList(trueDialogClient.getCurrentAccount(), throwIfEmpty);    }

    public List<Channel> getList(int accountId) {
        return executeEntityListCall(channelService.getList(accountId));
    }

    public List<Channel> getList(int accountId, boolean throwIfEmpty) {
        return executeEntityListCall(channelService.getList(accountId), throwIfEmpty);
    }


}
