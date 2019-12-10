package com.gpdi.dao.news;

import com.gpdi.entity.news.News;
import org.apache.ibatis.annotations.Param;

import javax.xml.ws.Response;
import java.util.List;

/**
 * 资讯管理
 *
 */
public interface NewsMapper {
    //增加资讯
    public void addNews(News news);

    //删除资讯
    public void delNewById(int id);

    //推送
    public News pushNewsById(int id);

    //分页查询资讯信息
    public List<News> getNewsListByCondition(@Param("page") int page,@Param("limit") int limit);

    //统计资讯的数量
    public int countNews();




}
