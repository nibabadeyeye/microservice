package com.gpdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/***
 *
 * memcache介绍：  what is memCache ？是什么
 *
 *                       高性能的、分布式的对象缓存系统
 *
 *                 why use  ？为什么
 *
 *                       使用通过设置缓存减小数据库压力
 *
 *                 How to use？ 怎么使用
 *
 *                        通过当前的案例
 *
 *
 *
 */
@SpringBootApplication
public class MemoryCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemoryCacheApplication.class, args);
	}
}
