package com.example.AddDemo.util.runnable;

/**
 * @Description
 * @Author Mr whs
 * @Date date
 */
public class RunnableTest implements  Runnable {
    @Override
    public void run() {
        System.out.println("用Runnable实现多线程");
    }
}
