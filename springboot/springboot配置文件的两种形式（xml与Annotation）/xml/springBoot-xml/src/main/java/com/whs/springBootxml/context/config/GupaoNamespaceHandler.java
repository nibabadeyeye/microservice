package com.whs.springBootxml.context.config;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
public class GupaoNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init()
    {
        registerBeanDefinitionParser("user",new UserBeanDefinitionParser());
    }
}
