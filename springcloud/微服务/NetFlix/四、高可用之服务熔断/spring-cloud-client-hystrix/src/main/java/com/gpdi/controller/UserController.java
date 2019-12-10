package com.gpdi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@RestController
public class UserController {
    /**
     * @desc:对远程服务设置超时自动熔断
     */
    @GetMapping(value = "countUserNumber")
    public String countUserNumber() {
        //创建一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        //模拟调用一个服务端应用程序
        Future f = executorService.submit(() -> {
            Random random = new Random();
            int time = random.nextInt(100);
            System.out.println("当前数值是"+time);
            try {
                Thread.sleep(time);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        try {
            f.get(50, TimeUnit.MILLISECONDS);
            return "请求成功";

        } catch (Exception e) {

            return "请求超时";
        }


    }

}
