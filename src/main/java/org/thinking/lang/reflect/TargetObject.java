package org.thinking.lang.reflect;

/**
 * @author choo
 */
public class TargetObject extends SuperTarget implements SuperInterface{

    private String value;

    public TargetObject() {
        value = "targetObj";
    }

    public void publicMethod(String s) {
        System.out.println("I love " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }
}
