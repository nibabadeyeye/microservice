package com.whs.util;

import redis.clients.jedis.Jedis;

/**集合的操作：集合可以存储多个值相同的字符串
 *  1、添加 sadd key value
 *  2、删除 srem name value
 *  3、检查集合中是否包含一个元素 sismember key
 *     查询集合中的所有元素 sismembers
 *
 * */
public class CoolecttionUtil
{
    Jedis jedis = new Jedis("localhost");

    public void get()
    {
        System.out.println("连接本地的 Redis 服务成功！");
        //清空user
        jedis.del("user");
        //添加
        jedis.sadd("user", "Tom");
        jedis.sadd("user", "Tom");
        jedis.sadd("user", "chenze");
        jedis.sadd("user", "likui");
        jedis.sadd("user", "liumen");
        //删除chenze
        jedis.srem("user", "chenze");
        System.out.println(jedis.smembers("user"));//获取所有的value
        System.out.println(jedis.sismember("user", "likui"));//判断集合中是否有该元素
        System.out.println(jedis.scard("user"));//返回集合的元素个数
    }
    public static void main(String[] args) {


    }
    //往集合中添加元素
    public void add()
    {
        jedis.sadd("user", "Tom");
        jedis.sadd("user", "Tom");
        jedis.sadd("user", "chenze");
        jedis.sadd("user", "likui");
        jedis.sadd("user", "liumen");

    }
    //删除指定集合中的一个是指
    public void dele(String name,String value)
    {
        jedis.srem(name,value);

    }
    //删除byte[]数组
    public void dele(byte[] name,byte[] value)
    {
        jedis.srem(name,value);

    }




}
