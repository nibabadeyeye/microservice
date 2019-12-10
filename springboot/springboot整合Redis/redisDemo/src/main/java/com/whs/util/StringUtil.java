package com.whs.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
/**
 * Redis中的String 类型针对数据库的操作
 * 1、get key
 * 2、set key value
 * 3、del key
 * */
@Repository
public class StringUtil {
    @Autowired
    private StringRedisTemplate StringRedisTemplate;
    //增加用户信息
    public  void  addUser(String key,String value)
    {
        ValueOperations<String, String> ops = this.StringRedisTemplate.opsForValue();
        if (!this.StringRedisTemplate.hasKey(key))
        {
            ops.set(key, value);
            System.out.println("set key success");
        } else {
            System.out.println("this key = " + ops.get(key));
        }
    };
    //删除用户
    public void deleteUser(String  key)
    {

            this.StringRedisTemplate.delete(key);
    };
    //修改用户
    public void update(String key,String value)
    {
           StringRedisTemplate.opsForValue().set(key,value);

    };
    //查询一个用户
    public String queryOne(String key)
    {

        return StringRedisTemplate.opsForValue().get(key);
    };

}
