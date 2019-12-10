package com.example.AddDemo.util.thread;

/**
 * @Description
 * @Author Mr whs
 * @Date date
 */
public class TestMutThread extends  Thread {
    @Override
    public void run() {
        System.out.println("这里用Thread执行我们的查询语句");
     //   super.run();
    }

    /**
     * 1、线程有几种状态？
     *                     1、初始化状态（我创建了一个线程，但是我现在还没有去掉用它，创建它的三种方式）
     *
     *
     *
     *   3、阻塞状态       2、运行时状态（调用了start方法）        4、等待状态
     *
     *
     *
     *
     *                     6、关闭状态                             5、时间等待状态
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     * */


}
