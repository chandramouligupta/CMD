package com.dummycall.calldummy;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class CallLogsListAdapter extends BaseAdapter {

    private ArrayList<CallLogItem> callLogItemArrayList;
    private Context context;

    public CallLogsListAdapter(Context context , ArrayList<CallLogItem> callLogItemArrayList) {
        this.callLogItemArrayList = callLogItemArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return callLogItemArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return callLogItemArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.activity_call_log_item, null);
        TextView directive = (TextView) v.findViewById(R.id.missed_dialed_recieved);
        TextView callerName = (TextView) v.findViewById(R.id.caller_name);
        TextView callerNo = (TextView) v.findViewById(R.id.caller_number);
        TextView callDuration = (TextView) v.findViewById(R.id.call_duration);
        //setting data in list items
        directive.setText(callLogItemArrayList.get(position).getDirective());
        callerName.setText(callLogItemArrayList.get(position).getCallerName());
        callerNo.setText(callLogItemArrayList.get(position).getCallerNumber());
        callDuration.setText(callLogItemArrayList.get(position).getCallDuration());
        return v;
    }
}
