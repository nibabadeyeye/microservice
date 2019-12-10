package com.gpdi.filter.config.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/*
 * 注册拦截器
 */
@SpringBootConfiguration
public class RegisterInteceptor implements WebMvcConfigurer {
	@Autowired
	private MyHandlerInterceptor myInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//addPathPatterns("/**")  拦截的路径;    excludePathPatterns("/login")  不拦截的路径
		registry.addInterceptor(myInterceptor).addPathPatterns("/**").excludePathPatterns("/login");
	}
}

