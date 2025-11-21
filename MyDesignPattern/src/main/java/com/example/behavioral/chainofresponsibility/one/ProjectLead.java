package com.example.behavioral.chainofresponsibility.one;

public class ProjectLead extends Employee {
    public ProjectLead(LeaveApprover successor) {
        super("Project Lead", successor);
    }

    @Override
    protected boolean processRequest(LeaveApplication application) {
        //type is sick leave & duration is less than or equal to 2 days
        if(application.getType() == LeaveApplication.Type.Sick) {
            if(application.getNoOfDays() <= 2) {
                application.approve(getApproverRole());
                return true;
            }
        }
        return false;
    }
}
