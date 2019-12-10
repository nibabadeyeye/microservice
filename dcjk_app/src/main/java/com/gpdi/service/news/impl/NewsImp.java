package com.gpdi.service.news.impl;

import com.gpdi.common.respone.ResponseData;
import com.gpdi.dao.news.NewsMapper;
import com.gpdi.entity.news.News;
import com.gpdi.service.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewsImp implements NewsService {

    @Override
    public ResponseData getNewsListByCondition(int page, int limit) {
        if(page>=1){
            page=(page-1)*limit;
        }
        List<News>newsList=newsMapper.getNewsListByCondition(page,limit);

        Map map=new HashMap();

        return null;
    }

    @Override
    public ResponseData addNews(News news) {
        newsMapper.addNews(news);
        return new ResponseData(200, "请求成功", null);
    }

    @Override
    public ResponseData delNewById(int id) {
        newsMapper.delNewById(id);
        return new ResponseData(200, "请求成功", null);
    }

    @Override
    public ResponseData pushNewsById(int id) {
        newsMapper.pushNewsById(id);
        return new ResponseData(200, "请求成功", null);
    }

    @Autowired
    private NewsMapper newsMapper;
}
