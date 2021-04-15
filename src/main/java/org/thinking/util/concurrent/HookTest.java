package org.thinking.util.concurrent;

import java.util.concurrent.Callable;

/**
 * @author Daniel:)
 */
public class HookTest {

    public static void main(String[] args) {
        Thread clearHook = new Thread() {
            public void run() {
                System.out.println("Run clearHook...");
            }
        };
        Runtime.getRuntime().addShutdownHook(clearHook);
        Runnable task1 = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Run task1...");
            }
        };
        Runnable task2 = new Thread() {
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Run task2...");
            }
        };
        task1.run();
        task2.run();
    }
}