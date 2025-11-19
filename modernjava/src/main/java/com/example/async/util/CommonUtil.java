package com.example.async.util;

import static com.example.async.util.LoggerUtil.log;
import static java.lang.Thread.sleep;

public class CommonUtil {
    //public static StopWatch stopWatch = new StopWatch();
    public static long start;
    public static long end;

    public static void startTimer(){
        stopWatchReset();
        start = System.currentTimeMillis();
    }

    public static void timeTaken(){
        //stopWatch.stop();
        end = System.currentTimeMillis();
        log("Total Time Taken : " + (end - start));
    }

    public static void delay(long delayMilliSeconds)  {
        try{
            sleep(delayMilliSeconds);
        }catch (Exception e){
            log("Exception is :" + e.getMessage());
        }

    }

    public static void stopWatchReset(){
        //stopWatch.reset();
        start = 0;
        end = 0;
    }
}
