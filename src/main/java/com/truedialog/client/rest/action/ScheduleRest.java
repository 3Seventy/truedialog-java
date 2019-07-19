package com.truedialog.client.rest.action;

import com.truedialog.client.model.action.ActionSchedule;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public class ScheduleRest {

    private static final String SCHEDULE_LIST = "account/{accountId}/action/{actionId}/schedule";
    private static final String SCHEDULE_ITEM = "account/{accountId}/action/{actionId}/schedule/{scheduleId}";
    private static final String SCHEDULE_CREATE = "account/{accountId}/action/{actionId}/schedule";
    private static final String SCHEDULE_DELETE = "account/{accountId}/action/{actionId}/schedule/{scheduleId}";

    public interface ScheduleService {


        @GET(SCHEDULE_LIST)
        Call<List<ActionSchedule>> getScheduleList(@Path("accountId") int accountId, @Path("actionId") int actionId);

        @GET(SCHEDULE_ITEM)
        Call<ActionSchedule> getSchedule(@Path("accountId") int accountId, @Path("actionId") int actionId, @Path("scheduleId") int scheduleId);

        @POST(SCHEDULE_CREATE)
        Call<ActionSchedule> createSchedule(@Path("accountId") int accountId, @Path("actionId") int actionId, @Body ActionSchedule schedule);

        @POST(SCHEDULE_CREATE)
        Call<ActionSchedule> updateSchedule(@Path("accountId") int accountId, @Path("actionId") int actionId, @Path("scheduleId") int scheduleId, @Body ActionSchedule schedule);

        @DELETE(SCHEDULE_DELETE)
        Call<ActionSchedule> deleteSchedule(@Path("accountId") int accountId, @Path("actionId") int actionId, @Path("scheduleId") int scheduleId);

    }

}
