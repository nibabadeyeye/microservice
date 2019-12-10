package com.whs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
/*Spring Cloud Ribbon有一个拦截器，它能够在这里进行实际调用的时候，
   自动的去选取服务实例，并将实际要请求的IP地址和端口替换这里的服务名，
   从而完成服务接口的调用。
   */
@RestController
public class DiscoverController {
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/consumer")
    public String dc() {
        /***这里获取的是服务名称而不是具体的地址可以看到这里，我们除了去掉了原来与LoadBalancerClient
         * 相关的逻辑之外，对于RestTemplate的使用，我们的第一个url参数有一些特别。这里请求的host位置
         * 并没有使用一个具体的IP地址和端口的形式，而是采用了服务名的方式组成。那么这样的请求为什么
         * 可以调用成功呢？因为Spring Cloud Ribbon有一个拦截器，它能够在这里进行实际调用的时候，自动
         * 的去选取服务实例，并将实际要请求的IP地址和端口替换这里的服务名，从而完成服务接口的调用。*/
        return restTemplate.getForObject("http://eureka-client-provider/dc", String.class);
    }
}
