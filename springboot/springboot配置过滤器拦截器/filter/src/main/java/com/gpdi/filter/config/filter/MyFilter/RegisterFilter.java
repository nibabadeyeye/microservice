package com.gpdi.filter.config.filter.MyFilter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author Mr whs
 * @Date date
 */

@Configuration
public class RegisterFilter{

    @Bean
    public FilterRegistrationBean timeFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        MyFilter myFilter = new MyFilter();
        filterRegistrationBean.setFilter(myFilter);
//        List<String> urls = new ArrayList<>();
//        urls.add("/users/*");
//        filterRegistrationBean.setUrlPatterns(urls);//配置过滤规则
        return filterRegistrationBean;
    }


}
