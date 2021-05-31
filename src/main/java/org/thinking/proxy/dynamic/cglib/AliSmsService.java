package org.thinking.proxy.dynamic.cglib;

/**
 * @author choo
 */
public class AliSmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
