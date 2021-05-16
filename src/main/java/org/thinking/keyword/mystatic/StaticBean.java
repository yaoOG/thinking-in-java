package org.thinking.keyword.mystatic;

/**
 * @author Daniel:)
 */
public class StaticBean {
    String name;
    //静态变量
    static int age;

    public StaticBean(String name) {
        this.name = name;
    }
    //静态方法
    static void sayHello() {
        System.out.println("Hello i am java");
    }
    @Override
    public String toString() {
        return "StaticBean{"+
                "name=" + name + ",age=" + age +
                "}";
    }
}
