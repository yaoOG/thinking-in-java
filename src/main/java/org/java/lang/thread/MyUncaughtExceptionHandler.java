package org.java.lang.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Daniel:)
 * 自定义Thread.UncaughtExceptionHandler
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("thread " + t.getName() + " occur exception");
    }

}
