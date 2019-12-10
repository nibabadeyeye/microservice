# Spring Cloud Feign



## 技术回顾

### [Netflix Eureka](http://git.gupaoedu.com/vip/xiaomage-space/tree/master/VIP%E8%AF%BE/spring-cloud/lesson-3)





### [RestTemplate](http://git.gupaoedu.com/vip/xiaomage-space/tree/master/VIP%E8%AF%BE/spring-cloud/lesson-4#spring-resttemplate)





### [Netflix Ribbon](http://git.gupaoedu.com/vip/xiaomage-space/tree/master/VIP%E8%AF%BE/spring-cloud/lesson-4#%E6%95%B4%E5%90%88netflix-ribbon)





### [Netflix Hystrix](http://git.gupaoedu.com/vip/xiaomage-space/tree/master/VIP%E8%AF%BE/spring-cloud/lesson-5)

注意：Hystrix 可以是服务端实现，也可以是客户端实现，类似于 AOP 封装：正常逻辑、容错处理。





## 申明式 Web 服务客户端：Feign

申明式：接口声明、Annotation 驱动

Web 服务：HTTP 的方式作为通讯协议

客户端：用于服务调用的存根

Feign：原生并不是 Spring Web MVC的实现，基于JAX-RS（Java REST 规范）实现。Spring Cloud 封装了Feign ，使其支持 Spring Web MVC。`RestTemplate`、`HttpMessageConverter`

> `RestTemplate `以及 Spring Web MVC 可以显示地自定义 `HttpMessageConverter `实现。



假设，有一个Java 接口 `PersonService`, Feign 可以将其声明它是以 HTTP 方式调用的。



### 注册中心（Eureka Server）：服务发现和注册

a. 应用名称：spring-cloud-eureka-server

b. 服务端口：12345

application.properties:

```properties
spring.application.name = spring-cloud-eureka-server
## Eureka 服务器端口
server.port =12345

### 取消服务器自我注册
eureka.client.register-with-eureka=false
### 注册中心的服务器，没有必要再去检索服务
eureka.client.fetch-registry = false

management.security.enabled = false
```



### Feign 声明接口（契约）：定义一种 Java 强类型接口

#### 模块：person-api

`PersonService`

```java
package com.gupao.spring.cloud.feign.api.service;

import com.gupao.spring.cloud.feign.api.domain.Person;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

/**
 * {@link Person} 服务
 *
 * @author 小马哥 QQ 1191971402
 * @copyright 咕泡学院出品
 * @since 2017/11/5
 */
@FeignClient(value = "person-service") // 服务提供方应用的名称
public interface PersonService {

    /**
     * 保存
     *
     * @param person {@link Person}
     * @return 如果成功，<code>true</code>
     */
    @PostMapping(value = "/person/save")
    boolean save(@RequestBody Person person);

    /**
     * 查找所有的服务
     *
     * @return
     */
    @GetMapping(value = "/person/find/all")
    Collection<Person> findAll();

}
```



### Feign 客户（服务消费）端：调用Feign 申明接口

#### 应用名称：person-client

#### 依赖：person-api



##### 创建客户端 Controller

```java
package com.gupao.spring.cloud.feign.client.web.controller;

import com.gupao.spring.cloud.feign.api.domain.Person;
import com.gupao.spring.cloud.feign.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * {@link PersonClientController} 实现 {@link PersonService}
 *
 * @author 小马哥 QQ 1191971402
 * @copyright 咕泡学院出品
 * @since 2017/11/5
 */
@RestController
public class PersonClientController implements PersonService {

    private final PersonService personService;

    @Autowired
    public PersonClientController(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public boolean save(@RequestBody Person person) {
        return personService.save(person);
    }

    @Override
    public Collection<Person> findAll() {
        return personService.findAll();
    }
}

```

#### 创建启动类

```java
package com.gupao.spring.cloud.feign.client;

import com.gupao.spring.cloud.feign.api.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Person Client 应用程序
 *
 * @author 小马哥 QQ 1191971402
 * @copyright 咕泡学院出品
 * @since 2017/11/5
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(clients = PersonService.class)
public class PersonClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonClientApplication.class,args);
    }
}
```

#### 配置 application.properties

```properties
spring.application.name = person-client

server.port = 8080

## Eureka Server 服务 URL,用于客户端注册
eureka.client.serviceUrl.defaultZone=\
  http://localhost:12345/eureka

management.security.enabled = false
```





### Feign 服务（服务提供）端：**不一定强制实现 Feign 申明接口**

#### 应用名称：person-service

#### 依赖：person-api



#### 创建 `PersonServiceController`

```java
package com.gupao.spring.cloud.feign.person.service.provider.web.controller;

import com.gupao.spring.cloud.feign.api.domain.Person;
import com.gupao.spring.cloud.feign.api.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * {@link PersonService} 提供者控制器（可选实现{@link PersonService}）
 *
 * @author 小马哥 QQ 1191971402
 * @copyright 咕泡学院出品
 * @since 2017/11/5
 */
@RestController
public class PersonServiceProviderController {

    private final Map<Long, Person> persons = new ConcurrentHashMap<>();

    /**
     * 保存
     *
     * @param person {@link Person}
     * @return 如果成功，<code>true</code>
     */
    @PostMapping(value = "/person/save")
    public boolean savePerson(@RequestBody Person person) {
        return persons.put(person.getId(), person) == null;
    }

    /**
     * 查找所有的服务
     *
     * @return
     */
    @GetMapping(value = "/person/find/all")
    public Collection<Person> findAllPersons() {
        return persons.values();
    }


}

```



#### 创建服务端应用



```java
package com.gupao.spring.cloud.feign.person.service.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * {@PersonService} 提供者应用
 *
 * @author 小马哥 QQ 1191971402
 * @copyright 咕泡学院出品
 * @since 2017/11/5
 */
@SpringBootApplication
@EnableEurekaClient
public class PersonServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonServiceProviderApplication.class,args);
    }

}
```



#### 配置 application.properties

```properties
## 提供方的应用名称需要和 @FeignClient 声明对应
spring.application.name = person-service
## 提供方端口 9090
server.port = 9090
## Eureka Server 服务 URL,用于客户端注册
eureka.client.serviceUrl.defaultZone=\
  http://localhost:12345/eureka
## 关闭管理安全
management.security.enabled = false
```



> Feign 客户（服务消费）端、Feign 服务（服务提供）端 以及 Feign 声明接口（契约） 存放在同一个工程目录。



### 调用顺序



PostMan -> person-client -> person-service



person-api 定义了 @FeignClients(value="person-service") , person-service 实际是一个服务器提供方的应用名称。



person-client 和 person-service 两个应用注册到了Eureka Server

person-client 可以感知 person-service 应用存在的，并且 Spring Cloud 帮助解析 `PersonService` 中声明的应用名称：“person-service”，因此 person-client 在调用 ``PersonService` `服务时，实际就路由到 person-service 的 URL



## 整合 Netflix Ribbon

#### 官方参考文档：http://cloud.spring.io/spring-cloud-static/Dalston.SR4/single/spring-cloud.html#spring-cloud-ribbon



#### 关闭 Eureka 注册

##### 调整 person-client 关闭 Eureka

```properties
ribbon.eureka.enabled = false
```

##### 定义服务 ribbon 的服务列表（服务名称：person-service）

```properties
person-service.ribbon.listOfServers = http://localhost:9090,http://localhost:9090,http://localhost:9090
```



#### 完全取消 Eureka 注册

```java
//@EnableEurekaClient //注释 @EnableEurekaClient
```



#### 自定义 Ribbon 的规则



##### 接口和 Netflix 内部实现

* IRule
  * 随机规则：RandomRule
  * 最可用规则：BestAvailableRule
  * 轮训规则：RoundRobinRule
  * 重试实现：RetryRule
  * 客户端配置：ClientConfigEnabledRoundRobinRule
  * 可用性过滤规则：AvailabilityFilteringRule
  * RT权重规则：WeightedResponseTimeRule
  * 规避区域规则：ZoneAvoidanceRule



##### 实现 IRule

```java
package com.gupao.spring.cloud.feign.client.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * 自定义实现 {@link IRule}
 *
 * @author 小马哥 QQ 1191971402
 * @copyright 咕泡学院出品
 * @since 2017/11/5
 */
public class FirstServerForeverRule extends AbstractLoadBalancerRule {


    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

    @Override
    public Server choose(Object key) {
        
        ILoadBalancer loadBalancer = getLoadBalancer();

        List<Server> allServers = loadBalancer.getAllServers();

        return allServers.get(0);
    }
}

```



##### 暴露自定义实现为 Spring Bean

```java
@Bean
public FirstServerForeverRule firstServerForeverRule(){
  return new FirstServerForeverRule();
}
```



##### 激活这个配置

```java
package com.gupao.spring.cloud.feign.client;

import com.gupao.spring.cloud.feign.api.service.PersonService;
import com.gupao.spring.cloud.feign.client.ribbon.FirstServerForeverRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;

/**
 * Person Client 应用程序
 *
 * @author 小马哥 QQ 1191971402
 * @copyright 咕泡学院出品
 * @since 2017/11/5
 */
@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients(clients = PersonService.class)
@RibbonClient(value = "person-service", configuration = PersonClientApplication.class)
public class PersonClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonClientApplication.class, args);
    }

    @Bean
    public FirstServerForeverRule firstServerForeverRule() {
        return new FirstServerForeverRule();
    }
}
```



##### 检验结果

通过调试可知：

```java
ILoadBalancer loadBalancer = getLoadBalancer();

// 返回三个配置 Server，即：
// person-service.ribbon.listOfServers = \
// http://localhost:9090,http://localhost:9090,http://localhost:9090
List<Server> allServers = loadBalancer.getAllServers();

return allServers.get(0);
```



##### 再次测试还原 Eureka注册的结果

注册三台服务提供方服务器：

```
PERSON-SERVICE	n/a (3)	(3)	UP (3) - 192.168.1.103:person-service:9090 , 192.168.1.103:person-service:9094 , 192.168.1.103:person-service:9097
```





## 整合 Netflix Hystrix

###  调整 Feign 接口

```java
package com.gupao.spring.cloud.feign.api.service;

import com.gupao.spring.cloud.feign.api.domain.Person;
import com.gupao.spring.cloud.feign.api.hystrix.PersonServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

/**
 * {@link Person} 服务
 *
 * @author 小马哥 QQ 1191971402
 * @copyright 咕泡学院出品
 * @since 2017/11/5
 */
@FeignClient(value = "person-service",fallback = PersonServiceFallback.class) // 服务提供方应用的名称
public interface PersonService {

    /**
     * 保存
     *
     * @param person {@link Person}
     * @return 如果成功，<code>true</code>
     */
    @PostMapping(value = "/person/save")
    boolean save(@RequestBody Person person);

    /**
     * 查找所有的服务
     *
     * @return
     */
    @GetMapping(value = "/person/find/all")
    Collection<Person> findAll();

}

```



### 添加 Fallback 实现



```java
package com.gupao.spring.cloud.feign.api.hystrix;

import com.gupao.spring.cloud.feign.api.domain.Person;
import com.gupao.spring.cloud.feign.api.service.PersonService;

import java.util.Collection;
import java.util.Collections;

/**
 * {@link PersonService} Fallback 实现
 *
 * @author 小马哥 QQ 1191971402
 * @copyright 咕泡学院出品
 * @since 2017/11/5
 */
public class PersonServiceFallback implements PersonService {

    @Override
    public boolean save(Person person) {
        return false;
    }

    @Override
    public Collection<Person> findAll() {
        return Collections.emptyList();
    }
}

```



### 调整客户端（激活Hystrix）

```java
package com.gupao.spring.cloud.feign.client;

import com.gupao.spring.cloud.feign.api.service.PersonService;
import com.gupao.spring.cloud.feign.client.ribbon.FirstServerForeverRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;

/**
 * Person Client 应用程序
 *
 * @author 小马哥 QQ 1191971402
 * @copyright 咕泡学院出品
 * @since 2017/11/5
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(clients = PersonService.class)
@EnableHystrix
//@RibbonClient(value = "person-service", configuration = PersonClientApplication.class)
public class PersonClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonClientApplication.class, args);
    }

    @Bean
    public FirstServerForeverRule firstServerForeverRule() {
        return new FirstServerForeverRule();
    }
}
```





## 问答部分

1. 能跟dubbo一样，消费端像调用本地接口方法一样调用服务端提供的服务么？还有就是远程调用方法参数对象不用实现序列化接口么？

   答： FeignClient 类似 Dubbo，不过需要增加以下 @Annotation，和调用本地接口类似

2. Feign通过注释驱动弱化了调用Service细节，但是Feign的Api设定会暴露service地址，那还有实际使用价值么？

   答：实际价值是存在的，Feign API 暴露 URI，比如："/person/save"

3. 整合ribbon不是一定要关闭注册中心吧？

   答： Ribbon 对于 Eureka 是不强依赖，不过也不排除

4. 生产环境上也都是feign的？

   答：据我所知，不少的公司在用，需要 Spring Cloud 更多整合：

   Feign 作为客户端

   Ribbon 作为负载均衡

   Eureka 作为注册中心

   Zuul 作为网管

   Security 作为安全 OAuth 2 认证

5. Ribbon直接配置在启动类上是作用所有的controller，那如果想作用在某个呢？

   答：Ribbon 是控制全局的负载均衡，主要作用于客户端 Feign，Controller是调用 Feign 接口，可能让人感觉直接作用了 Controller。

6. 其实eureka也有ribbon中简单的负载均衡吧

   答：Eureka 也要 Ribbon 的实现，可以参考`com.netflix.ribbon:ribbon-eureka`

7. 如果服务提供方，没有接口，我客户端一般咋处理？要根据服务信息，自建feign接口？

   答：当然可以，可是 Feign 的接口定义就是要求强制实现

8. 无法连接注册中心的老服务，如何调用cloud服务

   答：可以通过域名的配置 Ribbon 服务白名单

9. eureka 有时监控不到宕机的服务 正确的启动方式是什么

   答：这可以调整的心跳检测的频率





