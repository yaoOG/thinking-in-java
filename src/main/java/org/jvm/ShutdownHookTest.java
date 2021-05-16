package org.jvm;

/**
 * @author Daniel:)
 */
public class ShutdownHookTest {

    public static void main(String[] args) {
        boolean flag = true;
        Runtime.getRuntime().addShutdownHook(new Thread(()->
        {
            System.out.println("hook execute...");
        }));

        while (flag) {
            //app is running
        }

        System.out.println("main thread execute end...");
    }
}
