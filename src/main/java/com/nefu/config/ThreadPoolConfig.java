package com.nefu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

//线程池配置
@Configuration
@EnableAsync //开启多线程
public class ThreadPoolConfig {
    private static final int CORE_POOL_SIZE = 10;
    private static final int MAX_POOL_SIZE = 50;
    private static final int QUEUE_CAPACITY = 100;
    private static final int KEEP_ALIVE_TIME = 30;
    private static final String THREAD_NAME_PREFIX = "ThreadPool-";

    @Bean("taskExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(CORE_POOL_SIZE); //核心线程数
        taskExecutor.setMaxPoolSize(MAX_POOL_SIZE); //最大线程数
        taskExecutor.setQueueCapacity(QUEUE_CAPACITY); //队列容量
        taskExecutor.setKeepAliveSeconds(KEEP_ALIVE_TIME); //线程空闲时间
        taskExecutor.setThreadNamePrefix(THREAD_NAME_PREFIX); //线程名称
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true); //等待所有任务结束口关闭线程池
        //线程池初始化
        taskExecutor.initialize();
        return taskExecutor;
    }
}
