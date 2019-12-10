package com.example.AddDemo.util.callable;
import com.example.AddDemo.domain.User;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
/**
 * 描述：实现一个带返回值类型的多线程（Callable+ ExecutorService+Fature）
 *
 *  使用多线程的业务场景：
 *                   1、提高并行计算的效率
 *                   2、等待网络IO 导致的问题
 * @Author Mr whs
 * @Date 2019-03-24
 */
public class MutThreadOnCallable implements Callable<List> {

//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService= Executors.newCachedThreadPool();
//        System.out.println("测试");
//        MutThreadOnCallable testThread=new MutThreadOnCallable();
//        Future<List>future=executorService.submit(testThread);
//        System.out.println(future.get());
//        System.out.println("时间");
//        executorService.shutdown();
//    }
    @Override
    public List call() throws Exception {
        System.out.println("这里用Callable询数据库数据");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
      //  System.out.println("开始时间1  "+df.format(new Date()));
        for(int i=0;i<100000000;i++)
        {
            i++;
            if(i==1000000)
                 System.out.println(i);

        }
     //   System.out.println("开始时间1  "+df.format(new Date()));
        //从这里查询sqL语句
        List<User> list=new ArrayList<>();
        User user0=new  User();
        user0.setId(1);
        user0.setName("张三");
        list.add(user0);

        User user1=new  User();
        user1.setId(1);
        user1.setName("张三");
        list.add(user1);

        User user2=new  User();
        user2.setId(1);
        user2.setName("张三");
        list.add(user2);

        User user3=new  User();
        user3.setId(1);
        user3.setName("张三");
        list.add(user3);

        return list;
    }
}
