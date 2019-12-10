package com.gpdi.application;


import com.gpdi.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
        "com.gpdi.config",
        "com.gpdi.application"}
        )
public class GetIocBeanDefinitions {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(GetIocBeanDefinitions.class);
       // applicationContext.register(UserConfiguration.class);
       // applicationContext.refresh();
//        User user = (User) applicationContext.getBean(User.class);
//        User user1 = (User) applicationContext.getBean("user");
//        System.out.println(user1.getName());
     String arr[] = applicationContext.getBeanDefinitionNames();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(UserConfiguration.class);
//        User user = (User) applicationContext.getBean(User.class);
//        User user1 = (User) applicationContext.getBean("user");
//        System.out.println(user.getName());
//        String arr[] = applicationContext.getBeanDefinitionNames();
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
//    }
}
