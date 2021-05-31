package org.thinking.lang.thread;

/**
 * @author choo
 */
public class Demo {
    private static Object resource1 = new Object();//资源 1
    private static Object resource2 = new Object();//资源 2

    public static void main(String[] args) throws InterruptedException {
  /*      Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread() + "get resource1");
        }, "线程 1");
        thread.start();*/

        Integer integer = new Integer(1);
        integer.wait();
    }
}
