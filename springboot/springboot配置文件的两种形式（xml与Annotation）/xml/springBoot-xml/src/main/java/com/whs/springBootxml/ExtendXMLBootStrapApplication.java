package com.whs.springBootxml;
import com.whs.springBootxml.domain.UserEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class ExtendXMLBootStrapApplication {

    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/extend/context.xml");
        UserEntity user = context.getBean("user1", UserEntity.class);
        System.out.println(user);
        user = context.getBean("user2",UserEntity.class);
        System.out.println(user);
    }


}
