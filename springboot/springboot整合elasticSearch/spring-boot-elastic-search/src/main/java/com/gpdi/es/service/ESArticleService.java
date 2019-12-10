package com.gpdi.es.service;


import com.gpdi.common.domain.Article;
import com.gpdi.es.dao.ESArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @Auther: xf
 * @Date: 2019/1/13 14:56
 * @Description:
 */
@Service
public class ESArticleService {


    public Article save(Article article) {
        return articleRepository.save(article);

    }

    public Page<Article> query(int pageNumber, int pageSize, String searchContent) {
        // 分页
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        return articleRepository.findByNameLike(searchContent, pageRequest);

    }

    @Autowired
    ESArticleRepository articleRepository;
}
