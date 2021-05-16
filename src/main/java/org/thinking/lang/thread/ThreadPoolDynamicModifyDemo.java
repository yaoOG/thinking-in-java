package org.java.lang.thread;

import java.util.concurrent.*;

/**
 * @author Daniel:)
 */
public class ThreadPoolDynamicModifyDemo {


    /**
     * 自定义线程池
     * @return ThreadPoolExecutor
     */
    private static ThreadPoolExecutor buildThreadPoolExecutor() {
        return new ThreadPoolExecutor(2,
                5,
                60, TimeUnit.SECONDS,
                new ResizableCapacityLinkedBlockingQueue<>(10));
    }

    private static void threadPoolStatus(ThreadPoolExecutor executor, String name) {
        BlockingQueue<Runnable> queue = executor.getQueue();
        System.out.println(Thread.currentThread().getName() + "-" + name + "-："
                + "核心线程数:" + executor.getCorePoolSize() + " "
                + "活动线程数:" + executor.getActiveCount() + " "
                + "最大线程数:" + executor.getMaximumPoolSize() + " "
                + "线程活跃度:" + divide(executor.getActiveCount(), executor.getMaximumPoolSize()) + " "
                + "任务完成度:" + executor.getCompletedTaskCount() + " "
                + "队列大小:" + (queue.size() + queue.remainingCapacity()) + " "
                + "当前排队线程数:" + queue.size() + " "
                + "队列剩余大小:" + queue.remainingCapacity() + " "
                + "队列使用度:" + divide(queue.size(), queue.size() + queue.remainingCapacity())
        );
    }

    private static String divide(int num1, int num2) {
        return String.format("%1.2f%%", Double.parseDouble(num1 + "") / Double.parseDouble(num2 + "") * 100);
    }

    private static void dynamicModifyExecutor() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = buildThreadPoolExecutor();
        CountDownLatch countDownLatch = new CountDownLatch(15);

        for (int i = 0; i < 15; i++) {
            threadPoolExecutor.submit(() -> {
                threadPoolStatus(threadPoolExecutor, "创建任务");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        threadPoolStatus(threadPoolExecutor, "改变之前");
        threadPoolExecutor.setCorePoolSize(10);
        threadPoolExecutor.setMaximumPoolSize(10);
        threadPoolStatus(threadPoolExecutor, "改变之后");
        ResizableCapacityLinkedBlockingQueue<Runnable> queue = (ResizableCapacityLinkedBlockingQueue<Runnable>) threadPoolExecutor.getQueue();
        queue.setCapacity(100);
        countDownLatch.await();
        System.out.println("线程池 shutdown begin");
        threadPoolExecutor.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        dynamicModifyExecutor();
    }


}
