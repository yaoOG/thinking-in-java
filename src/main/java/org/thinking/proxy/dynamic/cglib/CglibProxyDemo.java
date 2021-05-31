package org.thinking.proxy.dynamic.cglib;

/**
 * @author choo
 */
public class CglibProxyDemo {
    public static void main(String[] args) {
        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        aliSmsService.send("java");
    }
}
