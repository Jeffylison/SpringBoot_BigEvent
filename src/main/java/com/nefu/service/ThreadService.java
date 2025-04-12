package com.nefu.service;

import com.nefu.mapper.ArticleMapper;
import com.nefu.pojo.Article;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ThreadService {

    //操作在线程池执行 不会影响主线程
    @Async("taskExecutor")
    public void updateArticleViewCount(ArticleMapper articleMapper, Article a) {
        try {
            Thread.sleep(5000);
            System.out.println("更新完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
