package org.java.lang.thread;


import jodd.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Daniel:)
 */
public class ThreadPoolHelper {
    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            10,
            50,
            2, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(1000),
            new ThreadFactoryBuilder().setNameFormat("demo-threadpool-%d").get());


    public static ThreadPoolExecutor getRightThreadPool() {
        return threadPoolExecutor;
    }
}
