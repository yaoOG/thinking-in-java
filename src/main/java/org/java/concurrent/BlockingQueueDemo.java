package org.java.concurrent;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Daniel:)
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>(10);
        boolean offerResult = arrayBlockingQueue.offer(1);
        System.out.println(offerResult);
    }
}
