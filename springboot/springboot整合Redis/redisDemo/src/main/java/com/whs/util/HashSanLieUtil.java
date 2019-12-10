package com.whs.util;
import com.whs.pojo.UserEntity;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
//哈希散列，可以存储多个键值对，特别适合存储对象
@Repository
public class HashSanLieUtil {

    Jedis jedis = new Jedis("127.0.0.1");
    public void get()
    {
        System.out.println("本地redis连接成功");
        //创建hashMap并添加数据
        Map<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("name", "Tom");
        hashMap.put("age", "12");
        hashMap.put("sex", "man");
        //添加hash类型数据
        jedis.hmset("user", hashMap);
        //第一个参数是redis中hash类型的key，第二、三、四个参数是map里面对用的key
        List<String> rsmap = jedis.hmget("user", "name", "age", "sex");
        System.out.println(rsmap);
        //删除map中的sex元素
        jedis.hdel("user", "sex");
        System.out.println(jedis.hmget("user", "sex"));//因为删除了所以返回null
        System.out.println(jedis.hlen("user"));//查看Map有多少元素
        System.out.println(jedis.exists("user"));//判断是否有user这个元素
        System.out.println(jedis.hkeys("user"));//获取user的key
        System.out.println(jedis.hvals("user"));//获取user的值
        Iterator<String> iterator = jedis.hkeys("user").iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + ":" + jedis.hmget("user", key));
        }
    }

    //添加一个对象
    public void addObject11()
    {
        Map<String,String>map=new HashMap<>();
        map.put("id","");
        map.put("uname","asa");
        map.put("upassword","asasa");
        jedis.hmset("use",map);
    }
    public void addObject()
    {
        Map<String,List<UserEntity>>map=new  HashMap<>();
        Map<String,UserEntity> mp=new HashMap();

        UserEntity user=new UserEntity();
        user.setId(1);
        user.setUname("admin");
        user.setUpassword("admin");
        mp.put("user",user);

        UserEntity user1=new UserEntity();
        user1.setId(2);
        user1.setUname("sa");
        user1.setUpassword("sa");
        mp.put("user",user1);
       // map.put("id","");
       // map.put("uname","asa");
       // map.put("upassword","asasa");

      // jedis.hmset("user",mp);
      // jedis.hm
    }

   //删除
    public void del()
    {

    }


}
