package com.gpdi.dubbo.imp;
import com.alibaba.dubbo.config.annotation.Service;
import com.gpdi.dubbo.HelloService;


@Service(version = "1.0.0")
public class HelloServiceImpl implements HelloService {

    @Override
    public String SayHello(String name) {
        return "Hello , "+name;
    }
}
