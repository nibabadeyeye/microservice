package com.gpdi.controller;
import com.gpdi.service.BusinessService;
import com.gpdi.entity.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * @author : whs
 * @description:交易订单控制器
 * @date 2019
 */

@RestController
public class BusinessController {

    @RequestMapping(value = "getBusiness")
    public long getBusiness() {
        long beginTime = System.currentTimeMillis();
        String sql = "select * from business limit 400";//6s
        List<Business> list = businessService.getBussinesListBySql(sql);
        //  System.out.println(list.get(0).getId());
        // System.out.println(list.get(399999).getId());
        long endTime = System.currentTimeMillis();
        return endTime - beginTime;


    }

    /**
     * */
    @RequestMapping(value = "getBusinessByThread")
    public long getBusinessByThread() throws Exception {


        int num = 400000;
        int everyPart = 80000;
        int allPart = 0;
        if (num % everyPart == 0) {
            allPart = num / everyPart;
        } else {
            allPart = num / everyPart + 1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < allPart; i++) {

            int key = i * everyPart + 1;
            int value = (i + 1) * everyPart;
            map.put(key, value);
        }


        long beginTime = System.currentTimeMillis();
        /**
         * @description:实现的思路
         *
         *   将20万数据分为5个线程
         * */

        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future> list = new ArrayList<>();
        int count = 1;

        for (Integer key : map.keySet()) {
            System.out.println("count的值" + count);
            //   System.out.println("key= "+ key + " and value= " + map.get(key));
            Callable callable = new MyCallable(count, key, map.get(key));
            Future future = pool.submit(callable);
            list.add(future);
            count += 1;
        }

        List<Business> allBusinessList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Object object = list.get(i).get();
            List<Business> list1 = (List<Business>) object;
            allBusinessList.addAll(list1);
        }

        System.out.println("拿到的是什么的数量" + allBusinessList.size());


        long endTime = System.currentTimeMillis();
        return endTime - beginTime;


    }

    class MyCallable implements Callable<Object> {
        private int taskId;
        private int beginId;
        private int endId;

        public int getBeginId() {
            return beginId;
        }

        public void setBeginId(int beginId) {
            this.beginId = beginId;
        }

        public int getEndId() {
            return endId;
        }

        public void setEndId(int endId) {
            this.endId = endId;
        }

        public MyCallable(int beginId, int endId) {
            this.beginId = beginId;
            this.endId = endId;
        }

        public int getTaskId() {
            return taskId;
        }

        public void setTaskId(int taskId) {
            this.taskId = taskId;
        }

        public MyCallable(int taskId, int beginId, int endId) {
            this.taskId = taskId;
            this.beginId = beginId;
            this.endId = endId;
        }

        @Override
        public Object call() throws Exception {
            System.out.println(">>>" + taskId + "号线程任务启动");
            String mysql = "select * from business where id>=" + beginId + "  and id<=" + endId;
            System.out.println("这个sql语句是" + mysql);
            List<Business> list = businessService.getBussinesListBySql(mysql);
            System.out.println(">>>" + taskId + "号线程任务完毕");
            return list;
        }
    }

    @Autowired
    BusinessService businessService;
}
