package com.gpdi.es.controller;

import com.gpdi.common.config.MyPointConfig;
import com.gpdi.common.domain.Article;
import com.gpdi.common.domain.SearchResult;
import com.gpdi.es.service.ESArticleService;
import com.gpdi.common.utils.ResponserData;
import com.gpdi.es.service.NearbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

/**
 * @Auther:
 * @Date: 2019/1/13 14:06
 * @Description:
 */
@RestController
public class ESArticleController {

    /**
     * @Desc:往ElasticSearch中增加一条数据
     */
    @PostMapping("save")
    public Object save(@RequestBody Article article) {
        return articleService.save(article);
    }

    /**
     * @desc:从ElasticSearch中根据条件进行分页查询
     */
    @GetMapping(value = "article/query")
    public ResponserData query(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                               @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                               @RequestParam(value = "searchContent") String searchContent) {
        long beginTime = System.currentTimeMillis();
        Page<Article> query = articleService.query(pageNumber, pageSize, searchContent);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - beginTime);
        return ResponserData.ok(query.getContent());
    }

    /**
     * @desc:初始化模拟数据
     *
     */
    @RequestMapping("createElasticsearchData")
    public ResponserData createEsData() {
        int total = 10000;
        int inserted = 0;
        try {
            //建库、建表、建约束
            nearbyService.recreateIndex();
            //随机产生10W条数据
            inserted = nearbyService.addDataToIndex(myPointConfig.getLat(), myPointConfig.getLon(), total);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponserData(200, "数据初始化成功");
    }

    /**
     * @desc:根据条件查询附近的人的坐标及相关信息
     */
    @RequestMapping("searchNearByPeople")
    public void searchNearby() {
        int size = 10, radius = 1000;
        System.out.println("开始获取距离" + myName + radius + "米以内人");
        SearchResult result = nearbyService.search(myPointConfig.getLat(), myPointConfig.getLon(), radius, size, "女");
        System.out.println("共找到" + result.getTotal() + "个人,优先显示" + size + "人，查询耗时" + result.getUseTime() + "秒");
        for (Map<String, Object> taxi : result.getData()) {
            String nickName = taxi.get("nickName").toString();
            String location = taxi.get("location").toString();
            Object geo = taxi.get("geoDistance");
            System.out.println(nickName + "，" +
                    "微信号:" + taxi.get("wxNo") +
                    "，性别:" + taxi.get("sex") +
                    ", 距离" + myName + geo + "米" +
                    "(坐标：" + location + ")");
        }
        System.out.println("以上" + size + "人显示在列表中......");

    }


    @Autowired
    private NearbyService nearbyService;


    @Autowired
    private MyPointConfig myPointConfig;

    @Autowired
    ESArticleService articleService;


    private String myName = "Tom";
}
