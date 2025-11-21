package com.example.behavioral.visitor.one;

import java.util.Collection;
import java.util.Collections;

public class AbstractEmployee implements Employee {
    private int performanceRating;
    private String name;
    private static int employeeIdCounter = 101;
    private int employeeId;

    public AbstractEmployee(String name) {
        this.name = name;
        this.employeeId = employeeIdCounter++;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int getPerformanceRating() {
        return this.performanceRating;
    }

    @Override
    public void setPerformanceRating(int rating) {
        this.performanceRating = rating;
    }

    @Override
    public Collection<Employee> getDirectReports() {
        return Collections.emptyList();
    }

    @Override
    public int getEmployeeId() {
        return this.employeeId;
    }

    @Override
    public void accept(Visitor visitor) {

    }
}
