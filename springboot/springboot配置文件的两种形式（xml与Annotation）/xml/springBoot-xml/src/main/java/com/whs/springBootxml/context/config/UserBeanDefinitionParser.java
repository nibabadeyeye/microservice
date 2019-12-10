package com.whs.springBootxml.context.config;
import com.whs.springBootxml.domain.UserEntity;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.lang.Nullable;
import org.w3c.dom.Element;
public class UserBeanDefinitionParser implements BeanDefinitionParser {
    @Nullable
    //@Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        //一、根据结点属性读取结点元素内容

        // 二、创建BeanDefinition

        //三、 通过parserContext获取BeanDefinitionRegister

        //四、注册BeanDefintion

        //五、使用BeanDefinition


        // XML 配置: <gupao:user id="1" name="${name}" />
        // 原始 String 类型 -> Long
        String uid = element.getAttribute("uid");
        // String 类型 -> Placeholder ${name}
        String uname = element.getAttribute("uname");
        String upassword = element.getAttribute("upassword");
        String beanName = element.getAttribute("bean-name");
        // BeanDefinition -> BeanDefinitionBuilder
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(UserEntity.class);
        // 添加 Property 值，来自于 XML 配置
        builder.addPropertyValue("uid", uid);
        builder.addPropertyValue("uname", uname);
        builder.addPropertyValue("upassword",upassword);
        // 创建 BeanDefinition
        BeanDefinition beanDefinition =  builder.getBeanDefinition();
        // 从 parserContext 获取 Bean 注册器
        BeanDefinitionRegistry beanDefinitionRegistry = parserContext.getRegistry();
        // 注册 Bean 定义
        beanDefinitionRegistry.registerBeanDefinition(beanName,beanDefinition);
        return beanDefinition;
    }
}
