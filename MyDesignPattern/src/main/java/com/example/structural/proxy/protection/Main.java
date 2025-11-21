package com.example.structural.proxy.protection;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Invoke checkWithoutProxy() method");
        checkWithoutProxy();
        System.out.println("Invoke checkWithProxy() DONE");
        System.out.println("Invoke checkWithProxy() method");
        checkWithProxy();
        System.out.println("Invoke checkWithProxy() DONE");
    }

    public static void checkWithProxy() {
        RepoProxy proxyRepository = new RepoProxy("/test/repo");

        proxyRepository.setAuthorizedRoles(Arrays.asList("Manager", "Tech Lead"));
        Employee e1 = new Employee("Saroj", "Programmer");
        Employee e2 = new Employee("Sachin", "Manager");
        Employee e3 = new Employee("Saurav", "Tech Lead");

        proxyRepository.setEmployee(e1);
        proxyRepository.createFile("data.txt");

        proxyRepository.setEmployee(e2);
        proxyRepository.deleteFile("data.txt");

        proxyRepository.setEmployee(e3);
        proxyRepository.deleteFile("data.txt");
    }

    public static void checkWithoutProxy() {
        Repository repository = new Repository("/test/repo");
        Employee e1 = new Employee("Saroj", "Programmer");
        Employee e2 = new Employee("Sachin", "Manager");
        Employee e3 = new Employee("Saurav", "Tech Lead");

        repository.setEmployee(e1);
        repository.createFile("data.txt");

        repository.setEmployee(e2);
        repository.deleteFile("data.txt");

        repository.setEmployee(e3);
        repository.deleteFile("data.txt");
    }
}
