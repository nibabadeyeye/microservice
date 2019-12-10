package com.gpdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * RPC框架实施的背景：
 *
 *           1、动态路由管理
 *
 *           2、服务的注册与发现
 *
 *           3、减少单点压力和对F5硬件的依赖
 *
 *           4、服务的熔断降级
 *
 *           5、服务间的依赖关系
 *
 *           6、成本问题
 *
 */
@SpringBootApplication
public class SpringbootDubboServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDubboServerApplication.class, args);
	}
}
