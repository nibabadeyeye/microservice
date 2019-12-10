package com.gpdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @desc: 一、mq的作用：
 *
 *               1、异步
 *                         特点：节约时间，可以在相同时间里干更多的事
 *
 *                          理解同步和异步： 同步是指：我给你发送消息，必须等你回消息我才能干其他事
 *
 *                                           异步是指：我给你发送消息，不必等你回我就直接去干其他事
 *
 *               2、削峰/限流
 *                          特点： 保证系统稳定的运行
 *
 *                          举例： 在秒杀中，我们可以用消息队列进行处理，当队列满了之后直接把后续
 *
 *                                 的请求丢弃。
 *
 *
 *               3、解耦
 *                            特点：保证我们的核心流程可用
 *
 *                            举例：在购买商品时，将下单、操作库存、发送短信等一系列操作进行
 *
 *                                    解耦成一个个单独的功能，交给对应的队列进行处理，同时还可以
 *
 *                                    提供重试机制，保证消息的准确投递
 *
 *
 *         二、市面上常见的mq中间件
 *
 *               1、rabbitmq
 *
 *               2、rocketMq (原产自ali)
 *
 *               3、kafka
 *
 *               4、Redis
 *
 *
 *
 *
 *
 *
 *
 */
@SpringBootApplication
public class MqApplication {

	public static void main(String[] args) {
		SpringApplication.run(MqApplication.class, args);
	}

}
