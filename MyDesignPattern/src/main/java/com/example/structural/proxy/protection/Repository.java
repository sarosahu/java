package com.example.structural.proxy.protection;

import java.nio.file.Path;

import static java.nio.file.Files.exists;

/**
 * Note: I am not implementing the createFile(), updateFile(),
 * deleteFile() and viewFile() here. But let's assume that
 * in real production system, it has prover validation of
 * path while create/update/delete/read operation.
 */
public class Repository implements Storage{
    private Employee employee;
    private String repoPath;

    public Repository(String repoPath) {
        this.repoPath = repoPath;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void createFile(String fileName) {
//        String path = repoPath + "/" + fileName;
//        if (!exists(Path.of(path))) {
//            throw new RuntimeException("Path " + path + " doesn't exist!");
//        }
        System.out.println("File is created by " + getEmployee().getName() + " successfully");
    }

    @Override
    public void updateFile(String fileName) {
        System.out.println("File is updated by " + getEmployee().getName() + " successfully");
    }

    @Override
    public void deleteFile(String fileName) {
        System.out.println("File is deleted by " + getEmployee().getName() + " successfully");
    }

    @Override
    public void viewFile(String fileName) {
        System.out.println("File is read by " + getEmployee().getName() + " successfully");
    }
}
