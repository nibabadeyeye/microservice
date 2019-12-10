package com.whs.rabbitMq.config.consumer.appointMethod;
import com.whs.rabbitMq.config.Entity.UserEntity;
import org.springframework.stereotype.Component;
@Component
public class Receiver {

   // private CountDownLatch latch = new CountDownLatch(10);
    public void receiveMessage(Object message)
    {
        System.out.println("Received <" + message + ">");
        //latch.countDown();
    }

//    public CountDownLatch getLatch()
//    {
//        return latch;
//    }

}