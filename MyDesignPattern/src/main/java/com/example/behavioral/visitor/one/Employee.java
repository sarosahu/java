package com.example.behavioral.visitor.one;

import java.util.Collection;

public interface Employee {
    public int getPerformanceRating();
    public void setPerformanceRating(int rating);
    public Collection<Employee> getDirectReports();
    public int getEmployeeId();
    void accept(Visitor visitor);
}
