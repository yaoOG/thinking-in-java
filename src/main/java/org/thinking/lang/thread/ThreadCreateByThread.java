package org.thinking.lang.thread;

/**
 * @author Daniel:)
 */
public class ThreadCreateByThread {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("ThreadCreateByThread Thread_current=" + Thread.currentThread());
            }
        };
        thread.start();
    }
}
