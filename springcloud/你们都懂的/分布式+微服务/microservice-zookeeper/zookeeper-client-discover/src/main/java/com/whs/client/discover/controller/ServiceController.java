package com.whs.client.discover.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ServiceController {

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 返回所有的服务名称
     *
     * @return
     */
    //获取服务名称 http://localhost:7071/services
    @GetMapping("/services")
    public List<String> getAllServices() {
        return discoveryClient.getServices();
    }

    //访问地址 随意一个端口+路由
    // http://localhost:7071/service/instances/spring-cloud-service-discovery-client
    @GetMapping("/service/instances/{serviceName}")
    public List<String> getAllServiceInstances(@PathVariable String serviceName) {
        return discoveryClient.getInstances(serviceName)
                .stream()
                .map(s ->
                        s.getServiceId() + " - " + s.getHost() + ":" + s.getPort()
                ).collect(Collectors.toList());
    }

}
