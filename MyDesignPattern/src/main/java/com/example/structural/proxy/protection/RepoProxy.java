package com.example.structural.proxy.protection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepoProxy implements Storage{
    private Repository repository;
    // We need to have authrized roles.
    Set<String> authorizedRoles = new HashSet<>();

    public RepoProxy(String repoPath) {
        repository = new Repository(repoPath);
    }
    private boolean isAuthorized() {
        if (authorizedRoles.isEmpty()) {
            throw new RuntimeException("Authorized roles not set.");
        }
        return authorizedRoles.contains(getEmployee().getRole());
    }

    public Employee getEmployee() {
        return repository.getEmployee();
    }

    public void setEmployee(Employee employee) {
        this.repository.setEmployee(employee);
    }

    public void setAuthorizedRoles(List<String> authorizedRoles) {
        for (String role : authorizedRoles) {
            this.authorizedRoles.add(role);
        }
    }

    @Override
    public void createFile(String fileName) {
        if (isAuthorized()) {
            repository.createFile(fileName);
        } else {
            System.out.println(getEmployee().getName() + " is not authorized to create file.");
        }
    }

    @Override
    public void updateFile(String fileName) {
        if (isAuthorized()) {
            repository.updateFile(fileName);
        } else {
            System.out.println(getEmployee().getName() + " is not authorized to update file.");
        }
    }

    @Override
    public void deleteFile(String fileName) {
        if (isAuthorized()) {
            repository.deleteFile(fileName);
        } else {
            System.out.println(getEmployee().getName() + " is not authorized to delete file.");
        }
    }

    @Override
    public void viewFile(String fileName) {
        if (isAuthorized()) {
            repository.viewFile(fileName);
        } else {
            System.out.println(getEmployee().getName() + " is not authorized to view file.");
        }
    }
}
