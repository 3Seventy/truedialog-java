package com.truedialog.client.rest.report;

import com.truedialog.client.model.report.MessageReportRow;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public class MessageReportRest {

    private static final String MESSAGE_REPORT_URL = "account/{accountId}/report/MessageLogReport";

    public interface MessageReportService {

        @GET(MESSAGE_REPORT_URL)
        Call<List<MessageReportRow>> getMessageReportRawList(@Path("accountId") int accountId,
                                                             @Query("from") String from,
                                                             @Query("to") String to,
                                                             @Query("filter") String filter); // TODO TEST!!
    }
}
