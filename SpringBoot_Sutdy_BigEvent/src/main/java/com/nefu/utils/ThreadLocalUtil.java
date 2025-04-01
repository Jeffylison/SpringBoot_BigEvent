package com.nefu.utils;

public class ThreadLocalUtil {
    //提供线程池对象
    private static final ThreadLocal THREAD_LOCAL = new ThreadLocal();

    //根据key获取value
    public static <T> T get() {
        return (T) THREAD_LOCAL.get();
    }

    //存储key value
    public static void set(Object value) {
        THREAD_LOCAL.set(value);
    }

    //清除线程 防止内存泄漏
    public static void remove() {
        THREAD_LOCAL.remove();
    }
}
