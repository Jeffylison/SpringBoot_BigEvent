package com.nefu.service;

import com.nefu.pojo.Article;
import com.nefu.pojo.PageBean;

public interface ArticleService {
    //新增文章
    void add(Article article);

    //条件分页列表查询
    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);

    //查询文章详细信息
    Article findById(Integer id);

    //更新文章
    void update(Article article);

    //删除文章
    void delete(Integer id);
}
