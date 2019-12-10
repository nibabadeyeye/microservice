package com.gpdi.web.mapper;

import com.gpdi.common.domain.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * @description:定义web 文章模块接口
 * 
 */
@Mapper
public interface WebArticleMapper {
    
    //根据文章内容查询文章信息
    public List<Article> getAllArticleByContent(String name);
    
}
