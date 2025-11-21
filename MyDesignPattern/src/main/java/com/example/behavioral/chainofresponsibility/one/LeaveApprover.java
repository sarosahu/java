package com.example.behavioral.chainofresponsibility.one;

public interface LeaveApprover {
    void processLeaveApplication(LeaveApplication application);

    String getApproverRole();
}
