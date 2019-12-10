package com.gupaoedu.service.impl;

import com.gupaoedu.entity.Merchant;
import com.gupaoedu.mapper.MerchantMapper;
import com.gupaoedu.service.MerchantService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: qingshan
 * @Date: 2018/10/25 16:17
 * @Description: 咕泡学院，只为更好的你
 */
@Service
public class MerchantServiceImpl implements MerchantService {
 /*
 * rabbit 交换机的类型有四种：
 *                        1、Direct exchange（直连交换机）
                          2、Fanout exchange（扇型交换机）
                          3、Topic exchange（主题交换机）
                          4、Headers exchange（头交换机）
 * **/

   //主题交换机中：队列通过路由键绑定到交换机上面
    @Value("${com.gupaoedu.topicexchange}")
    private String topicExchange;

    //路由键
    @Value("${com.gupaoedu.topicroutingkey1}")
    private String topicRoutingKey;

    //MyBatis操作工具
    @Autowired
    private MerchantMapper merchantMapper;

    //amaq操作的工具
    @Autowired
    AmqpTemplate gupaoTemplate;


    @Override
    public List<Merchant> getMerchantList(String name, int page, int limit) {
        return  merchantMapper.getMerchantList(name,page,limit);
    }

    @Override
    public Merchant getMerchantById(Integer id) {
        return merchantMapper.getMerchantById(id);
    }

    @Override
    public int add(Merchant merchant) {
        //数据库的操作
        int k = merchantMapper.add(merchant);
        System.out.println("aaa : "+merchant.getId());
        //封装json数据，这个可以带多种类型的数据（我们常用的有json报文）
        JSONObject title = new JSONObject();
        String jsonBody = JSONObject.toJSONString(merchant);
        title.put("type","add");
        title.put("desc","新增商户");
        title.put("content",jsonBody);
        //利用amaq提供的工具类进行相关的操作（携带三个参数：1：交换机名称 2,.路由键 3.json报文）
        gupaoTemplate.convertAndSend(topicExchange,topicRoutingKey, title.toJSONString());
        return k;
    }

    @Override
    public int updateState(Merchant merchant) {

        int k = merchantMapper.updateState(merchant);

        JSONObject title = new JSONObject();
        String jsonBody = JSONObject.toJSONString(merchant);
        title.put("type","state");
        title.put("desc","更新商户状态");
        title.put("content",jsonBody);
        gupaoTemplate.convertAndSend(topicExchange,topicRoutingKey, title.toJSONString());

        return k;
    }

    @Override
    public int update(Merchant merchant) {

        int k = merchantMapper.update(merchant);

        JSONObject title = new JSONObject();
        String jsonBody = JSONObject.toJSONString(merchant);
        title.put("type","update");
        title.put("desc","更新商户信息");
        title.put("content",jsonBody);
        gupaoTemplate.convertAndSend(topicExchange,topicRoutingKey, title.toJSONString());

        return k;
    }

    @Override
    public int delete(Integer id) {

        int k = merchantMapper.delete(id);

        JSONObject title = new JSONObject();
        Merchant merchant = new Merchant();
        merchant.setId(id);
        String jsonBody = JSONObject.toJSONString(merchant);
        title.put("type","delete");
        title.put("desc","删除商户");
        title.put("content",jsonBody);

        gupaoTemplate.convertAndSend(topicExchange,topicRoutingKey, title.toJSONString());

        return k;
    }

    @Override
    public int getMerchantCount() {

        return merchantMapper.getMerchantCount();
    }
}
