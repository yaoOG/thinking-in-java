package org.thinking.proxy.dynamic.jdk;

/**
 * @author choo
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("java");
    }
}
