package com.gpdi.web.controller;

import com.gpdi.common.domain.Article;
import com.gpdi.common.utils.ResponserData;
import com.gpdi.web.service.WebArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:springmvc请求入口类
 */

@RestController
public class WebArticleController {

    @GetMapping("/web/getArticle")
    public ResponserData getAllArticleListByContent(String name) {
        long beginTime = System.currentTimeMillis();
        List<Article> list = webArticleService.getAllArticleByContent(name);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - beginTime);
        return new ResponserData(200, "请求成功", list);
    }

    @Autowired
    private WebArticleService webArticleService;

}
