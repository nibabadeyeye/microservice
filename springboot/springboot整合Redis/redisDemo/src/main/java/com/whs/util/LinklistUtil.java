package com.whs.util;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import java.util.List;
/**
 * Redis中的链表link-list类型针对数据库的操作,都是针对String 类型的数据进行操作
 * 1、添加 rpush lpush ink-list-name value
 * 2、查询某个范围的值 lrange link-list-name 0 -1 (查询key所有的值)
 *    查询链表中某个具体的值lindex ink-list-name 0
 * 3、删除某个值 lpop lpop ink-list-name  value
 * */
@Repository
public class LinklistUtil {

    Jedis jedis = new Jedis("127.0.0.1");
    //对于link-list 可以一次添加一个Node,也可以一次添加多个Node
 public void add()
 {

     //存储数据到列表中
     jedis.lpush("IT", "JAVA");
     jedis.lpush("IT", "PHP");
     jedis.lpush("IT", "C++");
     //获取存储的数据并输出
     List<String> list = jedis.lrange("IT", 0, 3);
     list.forEach(string -> System.out.println(string));

 }

 //添加一条数据
    public void addOne(String key,String value)
    {

        jedis.lpush(key,value);
    }
 //添加多条key相同的数据
    public void addMulSamekey(String key,List<String> list)
    {
        for(int i=0;i<list.size();i++)
        {
            jedis.lpush(key,list.get(i));
        }
    }
    //添加多个key的值
    public void addMulSamekey(List<String> listkey,List<String> listValue)
    {
        for(int i=0;i<listkey.size();i++)
        {
            jedis.lpush(listkey.get(i),listValue.get(i));
        }
    }

    //删除某个名称的链表
    public void delete(String key)
    {
        jedis.lpop(key);
    }
    //定位结点的索引位置
    public String getIndex(String key,long value){
     return jedis.lindex(key,value);

    }
    //查询链表
    public String get(String key)
    {
       return   jedis.get(key);
    }
    //查询某个范围的结点值集合
    public List<String> getList(String key,int start,int end)
    {
        List<String>listString=jedis.lrange(key,start,end);
        return listString;
    }

}
