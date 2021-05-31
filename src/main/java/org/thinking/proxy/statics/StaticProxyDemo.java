package org.thinking.proxy.statics;

/**
 * @author choo
 */
public class StaticProxyDemo {
    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(smsService);
        smsProxy.send("java");
    }
}
