package com.dummycall.calldummy;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ContactItem> contactItemList;

    public ContactListAdapter(Context context, ArrayList<ContactItem> contactItemList) {
        this.context = context;
        this.contactItemList = contactItemList;
    }

    @Override
    public int getCount() {
        return contactItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v = View.inflate(context ,R.layout.contact_item,null );
        TextView contactId =  (TextView) v.findViewById(R.id.contact_id);
        TextView contactName =  (TextView) v.findViewById(R.id.contact_name);
        contactId.setText("Phone No:"+((ContactItem)contactItemList.get(position)).getContactId());
        contactName.setText(contactItemList.get(position).getContactName());
        return v;
    }
}
