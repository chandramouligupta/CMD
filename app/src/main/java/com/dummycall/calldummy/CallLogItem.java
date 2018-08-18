package com.dummycall.calldummy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CallLogItem{
// edited
    private String directive;
    private String callerName;
    private String callerNumber;
    private String callDuration;

    public CallLogItem(String directive, String callerName, String callerNumber, String callDuration) {
        this.directive = directive;
        this.callerName = callerName;
        this.callerNumber = callerNumber;
        this.callDuration = callDuration;
    }

    public String getDirective() {
        return directive;
    }

    public void setDirective(String directive) {
        this.directive = directive;
    }

    public String getCallerName() {
        return callerName;
    }

    public void setCallerName(String callerName) {
        this.callerName = callerName;
    }

    public String getCallerNumber() {
        return callerNumber;
    }

    public void setCallerNumber(String callerNumber) {
        this.callerNumber = callerNumber;
    }

    public String getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(String callDuration) {
        this.callDuration = callDuration;
    }
}
