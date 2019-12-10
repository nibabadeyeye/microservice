package com.example.AddDemo.controller;

import com.example.AddDemo.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Description
 * @Author Mr whs
 * @Date date
 */
@RestController
public class ThreadController {

    @RequestMapping("/testThread")
    public List<User> getAllUser()
    {

        ThreadQuery callable1=new ThreadQuery();
        FutureTask<List> futureTask1 = new FutureTask<List>(callable1);// 将Callable写的任务封装到一个由执行者调度的FutureTask对象
        ExecutorService executor = Executors.newFixedThreadPool(1);        // 创建线程池并返回ExecutorService实例
        executor.execute(futureTask1);  // 执行任务
        while (true) {
            try {

                if(!futureTask1.isDone()){ // 任务1没有完成，会等待，直到任务完成
                    System.out.println("线程一还在执行"+futureTask1.get());
                }

                System.out.println("等待线程二执行完成");
                List s = futureTask1.get(20000L, TimeUnit.MILLISECONDS);
                if(s !=null){
                    System.out.println("线程二的值"+s);
                }
            } catch (InterruptedException | ExecutionException e) {
              //  e.printStackTrace();
            }catch(TimeoutException e){

            }
        }

    }

    @RequestMapping("/tt")
    public List getList() throws  Exception{
//        long start = System.currentTimeMillis();//开始时间
//        List<List> tasks = new ArrayList<>();//用于产生结果
//        ThreadQuery threadQuery=new ThreadQuery();//多线程实现类
//
//
//
//
//        List qfe =threadQuery.call();
//
//        tasks.add(qfe);
//        ExecutorService executorService = Executors.newFixedThreadPool(15);
      //  executorService.
     //   List<List> futures=executorService.invokeAll(tasks);
        //executorService.invokeAny(tasks);
        //  executorService.invokeAll()
        //executorService.invokeAll(tasks);
        //处理线程返回结果
//        if(futures!=null&&futures.size()>0){
//            for (Future<List> future:futures){
//             //  ak= future.get();
//            }
//
//        }
//        executorService.shutdown();//关闭线程池
//        long end = System.currentTimeMillis();
//        System.out.println("线程查询数据用时:"+(end-start)+"ms");
//        List o = null;
      //  return o;
        return null;
    }
}
