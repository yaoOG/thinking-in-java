package org.java.lang.thread;

import java.util.concurrent.*;

/**
 * @author Daniel:)
 */
public class ThreadCreateByCallable {
    public static void main(String[] args) {

        //创建一个定长的核心线程和最大线程数都是1的FixedThreadPool线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);


        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                System.out.println("ThreadCreateByCallable Thread_current="+Thread.currentThread());
                return "callable thread";
            }
        };

        System.out.println("start");

        // 执行任务并获取Future对象
        Future<String> future = executorService.submit(callable);

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
