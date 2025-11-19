package com.example.async.completablefuture;

import com.example.async.service.HelloWorldService;

import java.util.concurrent.CompletableFuture;

import static com.example.async.util.CommonUtil.*;
import static com.example.async.util.LoggerUtil.log;

public class CompletableFutureHelloWorld {
    private final HelloWorldService hws;

    public CompletableFutureHelloWorld(HelloWorldService hws) {
        this.hws = hws;
    }

    public CompletableFuture<String> helloWorld() {
        return CompletableFuture.supplyAsync(hws::helloWorld)
                .thenApply(String::toUpperCase);
    }

    public String combineApproach1() {
        startTimer();
        String hello = hws.hello();
        String world = hws.world();
        timeTaken();
        return hello + world;
    }

    public String combineApproach2() {
        startTimer();
        CompletableFuture<String> ch = CompletableFuture.supplyAsync(hws::hello);
        CompletableFuture<String> cw = CompletableFuture.supplyAsync(hws::world);
        log("combining ch future to cw future");
        String hw = ch.thenCombine(cw, (h, w) -> h + w)
                .thenApply(String::toUpperCase)
                .join();
        timeTaken();
        return hw;
    }

    public String combine3AsyncTasks() {
        startTimer();
        CompletableFuture<String> ch = CompletableFuture.supplyAsync(hws::hello);
        CompletableFuture<String> cw = CompletableFuture.supplyAsync(hws::world);
        CompletableFuture<String> cNew =  CompletableFuture.supplyAsync(() -> {
            delay(1000);
            return " Hi CompletableFuture!";
        });

        String hw = ch
                .thenCombine(cw, (h, w) -> h + w)
                .thenCombine(cNew, (prev, curr) -> prev + curr)
                .thenApply(String::toUpperCase)
                .join();
        timeTaken();
        return hw;
    }

    public CompletableFuture<String> helloWorldAndThenCompose() {
        //startTimer();
        return CompletableFuture.supplyAsync(hws::hello)
                .thenCompose(hws::worldFuture)
                .thenApply(String::toUpperCase)
                ;

    }

    public static void main(String[] args) {
        HelloWorldService hws = new HelloWorldService();
        CompletableFuture.supplyAsync(() -> hws.helloWorld())
                .thenApply(res -> res.toUpperCase())
                .thenAccept((res) -> {
                    log("Result is : " + res);
                })
                .join();
        log("1 Done!");

        //HelloWorldService hws = new HelloWorldService();
        CompletableFuture.supplyAsync(hws::helloWorld)
                .thenApply(String::toUpperCase)
                .thenAccept((res) -> {
                    log("Result is : " + res);
                })
                .join();
        log("2 Done!");

        CompletableFutureHelloWorld c = new CompletableFutureHelloWorld(new HelloWorldService());
        System.out.println("Approach 1 ---");
        System.out.println(c.combineApproach1());
        System.out.println("Approach 1 --- DONE.");

        System.out.println("Approach 2 ---");
        System.out.println(c.combineApproach2());
        System.out.println("Approach 2 --- DONE.");

        System.out.println("Approach 3 ---");
        System.out.println(c.combine3AsyncTasks());
        System.out.println("Approach 3 --- DONE.");
        System.out.println("Approach 4 --- ");
        startTimer();
        System.out.println(c.helloWorldAndThenCompose().join());
        timeTaken();
        System.out.println("Approach 4 --- DONE.");
    }
}
