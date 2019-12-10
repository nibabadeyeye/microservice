package com.example.AddDemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * 描述：实现一个带返回值类型的多线程（Callable+ ExecutorService+Fature）
 *
 *  使用多线程的业务场景：
 *                   1、提高并行计算的效率
 *                   2、等待网络IO 导致的问题
 * @Author Mr whs
 * @Date 2019-03-24
 */

public class ThreadQuery implements Callable<List> {


    @Autowired
   private JdbcTemplate jdbcTemplate;

    public List call() throws Exception {
        System.out.println("这里用Callable查询数据库数据");
        List billList=this.jdbcTemplate.queryForList("select * from test");
        //从这里查询sqL语句
        System.out.println("数据长度"+billList.size());
        return billList;
    }
}
