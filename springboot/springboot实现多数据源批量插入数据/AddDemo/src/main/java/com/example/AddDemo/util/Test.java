package com.example.AddDemo.util;

import com.example.AddDemo.util.callable.MutThreadOnCallable;
import com.example.AddDemo.util.runnable.RunnableTest;
import com.example.AddDemo.util.thread.TestMutThread;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Description
 * @Author Mr whs
 * @Date date
 */
public class Test {
    public static void main(String[] args) {
        //测试Thread
        TestMutThread testMutThread=new TestMutThread();
        testMutThread.start();

        //测试Runnable
        RunnableTest runnableTest=new RunnableTest();
        Thread thread=new Thread(runnableTest);
        thread.start();

        //测试callable
        MutThreadOnCallable mutThreadOnCallable=new MutThreadOnCallable();
        ExecutorService executorService= Executors.newCachedThreadPool();
        MutThreadOnCallable testThread=new MutThreadOnCallable();
        Future<List> future=executorService.submit(testThread);
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        System.out.println("时间");
        executorService.shutdown();









    }
}
