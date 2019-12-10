package com.dalaoyang.controller;

import com.dalaoyang.entity.GoodsInfo;
import com.dalaoyang.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.controller
 * @email yangyang@dalaoyang.cn
 * @date 2018/5/4
 */
@RestController
public class GoodsController {

    @Autowired
    private GoodsRepository goodsRepository;

    //http://localhost:8888/save
    @GetMapping("save")
    public String save() {
        GoodsInfo goodsInfo = new GoodsInfo();
        goodsInfo.setId(1);
        goodsInfo.setName("苹果");
        goodsInfo.setDescription("今年吃不起");
        goodsRepository.save(goodsInfo);
        return "success";
    }

    //http://localhost:8888/delete?id=1
    @GetMapping("delete")
    public String delete(long id) {
        goodsRepository.findById(id);
        return "success";
    }

    //http://localhost:8888/update?id=1525417362754&name=修改&description=修改
    @GetMapping("update")
    public String update(int id, String name, String description) {
        GoodsInfo goodsInfo = new GoodsInfo(id, name, description);
        goodsRepository.save(goodsInfo);
        return "success";
    }

    //http://localhost:8888/getOne?id=1525417362754
    @GetMapping("getOne")
    public Optional<GoodsInfo> getOne(long id) {
        long beginTime = System.currentTimeMillis();
        Optional<GoodsInfo> goodsInfo = goodsRepository.findById(id);
        long endTime = System.currentTimeMillis();
        System.out.println("This quey is take " + (endTime - beginTime));
        return goodsInfo;
    }


    //每页数量
    private Integer PAGESIZE = 10;

    //http://localhost:8888/getGoodsList?query=商品
    //http://localhost:8888/getGoodsList?query=商品&pageNumber=1
    //根据关键字"商品"去查询列表，name或者description包含的都查询
//    @GetMapping("getGoodsList")
//    public List<GoodsInfo> getList(Integer pageNumber,String query){
//        if(pageNumber==null) pageNumber = 0;
//        //es搜索默认第一页页码是0
//        SearchQuery searchQuery=getEntitySearchQuery(pageNumber,PAGESIZE,query);
//        Page<GoodsInfo> goodsPage = goodsRepository.search(searchQuery);
//        return goodsPage.getContent();
//    }


    //   private SearchQuery getEntitySearchQuery(int pageNumber, int pageSize, String searchContent) {
//        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
//                .add(QueryBuilders.matchPhraseQuery("name", searchContent),
//                        ScoreFunctionBuilders.weightFactorFunction(100))
//                .add(QueryBuilders.matchPhraseQuery("description", searchContent),
//                        ScoreFunctionBuilders.weightFactorFunction(100))
//                //设置权重分 求和模式
//                .scoreMode("sum")
//                //设置权重分最低分
//                .setMinScore(10);
//
//        // 设置分页
//        Pageable pageable = new PageRequest(pageNumber, pageSize);
//        return new NativeSearchQueryBuilder()
//                .withPageable(pageable)
//                .withQuery(functionScoreQueryBuilder).build();
//    }

}
