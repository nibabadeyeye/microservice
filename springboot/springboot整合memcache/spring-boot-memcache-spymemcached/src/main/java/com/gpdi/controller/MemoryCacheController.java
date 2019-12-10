package com.gpdi.controller;
import com.gpdi.config.MemcachedRunner;
import com.gpdi.util.ResponseData;
import net.spy.memcached.MemcachedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;


@RestController
public class MemoryCacheController {

    /**
     * 设置缓存值
     */
    @GetMapping(value="saveMessage")
    public ResponseData saveMessage(String name){
        MemcachedClient memcachedClient = memcachedRunner.getClient();
        memcachedClient.set("name",1000,name);
        return new ResponseData("设置缓存成功",200);
    }

    /**
     * 获取缓存值
     */

    @GetMapping(value="getNameFromMemoryCache")
    public ResponseData getNameFromMemoryCache(){
        MemcachedClient memcachedClient = memcachedRunner.getClient();
        String name=memcachedClient.get("name").toString();
        return new ResponseData("查询缓存成功",200,name);
    }

    @Resource
    private MemcachedRunner memcachedRunner;


}
