package com.nefu;

import org.junit.jupiter.api.Test;


public class ThreadLocalTest {
    @Test
    public void testThreadLocalSetGet() {
        //提供ThreadLocal对象
        ThreadLocal tl = new ThreadLocal();

        //开启两线程
        new Thread(() -> {
            tl.set("1.1");
            System.out.println(Thread.currentThread().getName() + ": " + tl.get());
        }, "1").start();

        new Thread(() -> {
            tl.set("2.1");
            System.out.println(Thread.currentThread().getName() + ": " + tl.get());
        }, "2").start();
    }
}
