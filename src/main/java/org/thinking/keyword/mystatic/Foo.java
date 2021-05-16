package org.thinking.keyword.mystatic;

/**
 * @author Daniel:)
 */
public class Foo {
    int i;
    public Foo(int i) {
        this.i = i;
    }

    public static String method1() {
        return "An example string that doesn't depend on i (an instance variable)";

    }

    public int method2() {
        return this.i + 1;  //Depends on i
    }

    public static void main(String[] args) {
        Foo bar = new Foo(1);
        String s = bar.method1();
        int i = bar.method2();
        System.out.println("method1:"+s+", method2:"+i);
    }
}
