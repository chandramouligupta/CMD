package com.dummycall.calldummy;

import android.database.Cursor;
import android.provider.CallLog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class CallLogsList extends AppCompatActivity {

    private ListView callLogsListView;
    private ArrayList<CallLogItem> callLogItemArrayList;
    private CallLogsListAdapter callLogListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_logs_list);
        callLogsListView = (ListView) findViewById(R.id.call_logs_list);
        setCallLogItemArrayList();
        callLogListAdapter = new CallLogsListAdapter(this , callLogItemArrayList);
        callLogsListView.setAdapter(callLogListAdapter);
    }

    private void setCallLogItemArrayList(){
        callLogItemArrayList = new ArrayList<>();
        Cursor cursor = getContentResolver().query(CallLog.Calls.CONTENT_URI ,
                        null ,null , null ,
                        CallLog.Calls.DATE + " DESC");
        int number = cursor.getColumnIndex(CallLog.Calls.NUMBER);
        int type = cursor.getColumnIndex(CallLog.Calls.TYPE);
        int date = cursor.getColumnIndex(CallLog.Calls.DATE);
        int duration = cursor.getColumnIndex(CallLog.Calls.DURATION);
        int clname = cursor.getColumnIndex(CallLog.Calls.CACHED_NAME);
        while(cursor.moveToNext() && cursor != null){
            String phNumber = cursor.getString(number);
            String callType = cursor.getString(type);
            String callDate = cursor.getString(date);
            String callerName = cursor.getString(clname) != null?cursor.getString(clname):"";
            Date callDayTime = new Date(Long.valueOf(callDate));
            String callDuration = cursor.getString(duration);
            String dir = null;
            int dirCode = Integer.parseInt(callType);
            switch (dirCode) {
                case CallLog.Calls.OUTGOING_TYPE:
                    dir = "OUTGOING";
                    break;
                case CallLog.Calls.INCOMING_TYPE:
                    dir = "INCOMING";
                    break;

                case CallLog.Calls.MISSED_TYPE:
                    dir = "MISSED";
                    break;
            }
            CallLogItem callLogItem = new CallLogItem(dir,callerName,phNumber,callDuration);
            callLogItemArrayList.add(callLogItem);
        }
    }
}
