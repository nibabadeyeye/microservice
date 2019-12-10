package com.whs.util;

import redis.clients.jedis.Jedis;
/*有序集合，也是一种键值对，通常键称为成员每个成员是各不相同的，值称为分数
* 增加：zadd queueName xuhao key(member)
* 查询所有：zrange  queueName 0 -1 withscores
* 删除 ：zrem queueName member(key)
*
*
* */
public class SequeueCollection {
    Jedis jedis = new Jedis("127.0.0.1");
    public void get()
    {
        System.out.println("连接本地的 Redis 服务成功！");
        //jedis排序
        //注意，此处rpush和lpush是list的操作。是一个双向链表
        jedis.del("a");//先清除数据
        jedis.rpush("a", "1");
        jedis.rpush("a", "6");
        jedis.rpush("a", "4");
        jedis.rpush("a", "9");
        jedis.rpush("a", "2");
        System.out.println(jedis.lrange("a", 0, -1));
        System.out.println(jedis.sort("a"));
        System.out.println(jedis.lrange("a", 0, -1));
    }
    public static void main(String[] args) {



    }


}
