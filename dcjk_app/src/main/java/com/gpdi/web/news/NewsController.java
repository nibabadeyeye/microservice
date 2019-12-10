package com.gpdi.web.news;

import com.gpdi.common.respone.ResponseData;
import com.gpdi.service.item.ItemService;
import com.gpdi.service.news.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api("资讯管理")
@RestController
@RequestMapping("/news")
public class NewsController {


    @ApiOperation("/分页获取资讯信息")
    @PostMapping("/getNewsListByCondition")
    public ResponseData getNewsListByCondition(int page, int limit) {
        return newsService.getNewsListByCondition(page, limit);
    }


    @Autowired
    private NewsService newsService;
}
