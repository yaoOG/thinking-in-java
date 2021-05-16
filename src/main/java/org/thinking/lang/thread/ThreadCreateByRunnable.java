package org.thinking.lang.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Daniel:)
 */
public class ThreadCreateByRunnable {
    public static void main(String[] args) {
        //创建一个定长的核心线程和最大线程数都是1的FixedThreadPool线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("ThreadCreateByRunnable Thread_current=" + Thread.currentThread());
            }
        };

        System.out.println("start");

        Future<?> future = executorService.submit(runnable);

        try{
            //future.get()线程结果，会阻塞当前线程直到线程结束
            System.out.println("future.get()="+future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("end");

        // 关闭线程池
        executorService.shutdown();
    }
}
