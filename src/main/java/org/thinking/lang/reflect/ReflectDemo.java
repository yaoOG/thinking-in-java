package org.thinking.lang.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author choo
 */
public class ReflectDemo {
    public static void main(String[] args) throws Exception {
//        /*
//         * 获取TargetObject类的Class对象并且创建TargetObject类实例
//         */
//        Class<?> tagetClass = Class.forName("org.thinking.lang.reflect.TargetObject");
//        TargetObject targetObject = (TargetObject) tagetClass.newInstance();
//
//        /*
//         * 获取所有类中所有定义的方法
//         */
//
//        Method[] methods = tagetClass.getDeclaredMethods();
//        for (Method method : methods) {
//            System.out.println(method.getName());
//        }
//
//        /*
//         *获取指定方法并调用
//         */
//
//        Method publicMethod = tagetClass.getDeclaredMethod("publicMethod",
//                String.class);
//        publicMethod.invoke(targetObject, "ReflectDemo");
//
//         /*获取指定参数并对参数进行修改*/
//
//        Field field = tagetClass.getDeclaredField("value");
//        //为了对类中的参数进行修改我们取消安全检查
//        field.setAccessible(true);
//        field.set(targetObject, "ReflectDemo");
//
//         /*调用 private 方法*/
//
//        Method privateMethod = tagetClass.getDeclaredMethod("privateMethod");
//        //为了调用private方法我们取消安全检查
//        privateMethod.setAccessible(true);
//        privateMethod.invoke(targetObject);
//
//        //获取父类
//        Class<?> superclass = tagetClass.getSuperclass();
//        //获取接口
//        Class<?>[] interfaces = tagetClass.getInterfaces();

        //反射越过泛型检查
        List<String> list = new ArrayList<>();
        list.add("one");
        //反射获取list对象
        Class listClass = list.getClass();
        // 调用list对象的add方法
        Method m = listClass.getMethod("add", Object.class);
        m.invoke(list, 100);
        //输出验证
        for (Object obj : list) {
            System.out.println(obj);
        }

    }
}
