package org.jvm;

/**
 * @author Daniel:)
 */
public class NotInitialization {
    public static void main(String[] args) {
        SuperClass[] sca = new SuperClass[10];
        System.out.println("Test NotInitialzation Demo");
//        System.out.println(SubClass.value);
    }
}
