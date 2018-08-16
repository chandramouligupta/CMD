package com.dummycall.calldummy;


public class ContactItem{

    private String contactName;
    private String contactId;

    public ContactItem(String contactId , String contactName) {
        this.contactName = contactName;
        this.contactId = contactId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }
}
