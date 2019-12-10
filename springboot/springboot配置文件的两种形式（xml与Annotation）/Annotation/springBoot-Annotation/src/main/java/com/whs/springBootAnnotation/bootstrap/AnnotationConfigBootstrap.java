package com.whs.springBootAnnotation.bootstrap;
import com.whs.springBootAnnotation.config.UserConfig;
import com.whs.springBootAnnotation.domain.UserEntity;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class AnnotationConfigBootstrap {
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
        applicationContext.register(UserConfig.class);
        applicationContext.refresh();
        UserEntity user = applicationContext.getBean("user", UserEntity.class);
        System.out.printf("user.getName() = %s \n",user.getUname());
    }
}
