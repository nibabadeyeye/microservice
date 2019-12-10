package com.whs.springBootxml.conf;
import com.whs.springBootxml.domain.UserEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 * XML 配置引导程序
 * 广告资源位...
 *
 * @author mercyblitz
 * @date 2017-10-09
 **/
public class XmlConfigBootstrap {

    public static void main(String[] args)
    {
        // 构建一个 Spring Application 上下文
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocations("classpath:/META-INF/context.xml");
        applicationContext.refresh();
        UserEntity user = applicationContext.getBean("user", UserEntity.class);
        System.out.printf("user.getName() = %s \n",user.getUname());
    }

}
