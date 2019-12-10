package com.gpdi.web.impl;

import com.gpdi.common.domain.Article;
import com.gpdi.web.mapper.WebArticleMapper;
import com.gpdi.web.service.WebArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ArticleImpl implements WebArticleService {
    @Override
    public List<Article> getAllArticleByContent(String name) {
        return articleMapper.getAllArticleByContent(name);
    }

    @Autowired
    private WebArticleMapper articleMapper;
}
