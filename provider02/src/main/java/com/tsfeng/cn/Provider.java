package com.tsfeng.cn;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tsfeng
 * @version 创建时间 2018/2/10 13:22
 */
class Provider {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.start();
        System.out.println("provider02 start success");
        System.in.read();
    }
}
