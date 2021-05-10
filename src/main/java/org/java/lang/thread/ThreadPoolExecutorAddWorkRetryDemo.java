package org.java.lang.thread;

/**
 * @author Daniel:)
 */
public class ThreadPoolExecutorAddWorkRetryDemo {
    public static void main(String[] args) {
        int count = 0;
        retry:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                count++;
                if (count == 4) {
//                    continue retry;
                    break retry;
                }
                System.out.println(count);
            }
        }
    }


/*    public static void main(String[] args) {
        int count = 0;
        retry:
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 2; k++) {
                for (int j = 0; j < 5; j++) {
                    count++;
                    if (count == 4) {
                        continue retry;
                    }
                    System.out.print(count + " ");
                }
            }
        }
    }*/
}
