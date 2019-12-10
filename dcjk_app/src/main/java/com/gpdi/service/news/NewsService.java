package com.gpdi.service.news;

import com.gpdi.common.respone.ResponseData;
import com.gpdi.entity.news.News;

import javax.xml.ws.Response;

/**
 * 资讯管理
 *
 */
public interface NewsService {
    //增加资讯
    public ResponseData addNews(News news);

    //删除资讯
    public ResponseData delNewById(int id);

    //推送
    public ResponseData pushNewsById(int id);

    //分页查询资讯信息
    public ResponseData getNewsListByCondition(int page,int limit);




}
