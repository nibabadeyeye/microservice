package com.gpdi.web.service;

import com.gpdi.common.domain.Article;

import java.util.List;

/**
 *
 * @description:定义web 文章模块接口
 *
 */
public interface WebArticleService {

    //根据文章内容查询文章信息
    public List<Article> getAllArticleByContent(String name);

}
