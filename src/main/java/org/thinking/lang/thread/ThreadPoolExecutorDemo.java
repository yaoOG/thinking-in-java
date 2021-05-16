package org.thinking.lang.thread;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * @author Daniel:)
 * 线程池异常处理方式总结
 * https://www.cnblogs.com/ncy1/articles/11629933.html
 * https://github.com/aCoder2013/blog/issues/3
 * https://www.jianshu.com/p/30e488f4e021
 */
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {
//        ThreadPoolTaskExecutor executorService = buildThreadPoolTaskExecutor();
//        executorService.submit(() -> run("execute方法"));
//        extendedExecutor.execute(() -> run("execute方法"));
//        Future<?> result=executorService.submit(() -> run("submit方法"));
//        try {
//            result.get();
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        //1.创建一个自己定义的线程池,重写afterExecute方法
/*        ExecutorService service = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS,new LinkedBlockingQueue(10)){
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                System.out.println("afterExecute里面获取到异常信息"+t.getMessage());
            }
        };


        //2.提交任务
        service.execute(()->{
            int i=1/0;
        });*/

        //创建一个自己定义的线程池,重写afterExecute方法
        ExecutorService service = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(10)) {
            //重写afterExecute方法
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                if (t != null) { //这个是excute提交的时候
                    System.out.println("afterExecute里面获取到异常信息" + t.getMessage());
                }

                //如果r的实际类型是FutureTask 那么是submit提交的，所以可以在里面get到异常
                if (r instanceof FutureTask) {
                    try {
                        Future<?> future = (Future<?>) r;
                        future.get();
                    } catch (Exception e) {
                        System.out.println("future里面取执行异常 " + e.toString());
                    }
                }
            }
        };

        //2.提交任务
        service.submit(() -> {
            int i = 1 / 0;
        });

        service.shutdown();
    }

    private static void run(String name) {
        String printStr = "【thread-name:" + Thread.currentThread().getName() + ",执行方式:" + name + "】";
        System.out.println(printStr);
        throw new RuntimeException(printStr + ",出现异常");
    }

    private static ThreadPoolTaskExecutor buildThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executorService = new ThreadPoolTaskExecutor();
        executorService.setThreadNamePrefix("(小罗技术笔记)-");
        executorService.setCorePoolSize(5);
        executorService.setMaxPoolSize(10);
        executorService.setQueueCapacity(100);
        executorService.setKeepAliveSeconds(10);
        executorService.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executorService.initialize();
        return executorService;
    }

    /*public static ThreadFactory getMyThreadFactory() {
        return new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
                return thread;
            }
        };
    }*/

    /*public static void main(String[] args) {
        //创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
//        ExecutorService executorService = Executors.newCachedThreadPool();
        //创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
//        ExecutorService executorService1 = Executors.newFixedThreadPool(10);
        //创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
//        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        //创建一个定长线程池，支持定时及周期性任务执行。
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        //WorkStealingPool线程池，来维持相应的并行级别，它会通过工作窃取的方式，使得多核的 CPU 不会闲置，总会有活着的线程让 CPU 去运行。
//        ExecutorService executorService3 = Executors.newWorkStealingPool();

        //使用execute方式在每个线程维度捕获异常
*//*        ExecutorService executorService1 = Executors.newFixedThreadPool(10);
        int j = 3;

        try {
            for (int i = 0; i < 4; i++) {
                int finalJ = j;
                try {
                    executorService1.execute(new Runnable() {
                        @Override
                        public void run() {
                            int l = 1 / finalJ;
                            System.out.println("l=" + l + " finalJ=" + finalJ);
                        }
                    });
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                j--;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*//*

        //使用submit方式在线程池维度捕获异常
*//*        ExecutorService executorService1 = Executors.newFixedThreadPool(10);
        int j = 3;
        for (int i = 0; i < 4; i++) {
            int finalJ = j;

            Future<?> submit = executorService1.submit(new Runnable() {
                @Override
                public void run() {
                    int l = 1 / finalJ;
                    System.out.println("l=" + l + " finalJ=" + finalJ);
                }
            });
            try {
                Object o = submit.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            j--;
        }*//*


        //自定义UncaughtExceptionHandler方式
        ExecutorService executorService1 = Executors.newFixedThreadPool(10, getMyThreadFactory());
        int j = 3;
        for (int i = 0; i < 4; i++) {
            int finalJ = j;
            try {
                executorService1.execute(new Runnable() {
                    @Override
                    public void run() {
                        int l = 1 / finalJ;
                        System.out.println("l="+l+" finalJ="+finalJ);
                    }
                });
            } catch (Exception e) {
                System.out.println("已捕获子线程异常");
                e.printStackTrace();
            }
            j--;
        }
        System.out.println("主线程准备终止线程池");
        executorService1.shutdown();

    }*/
}
