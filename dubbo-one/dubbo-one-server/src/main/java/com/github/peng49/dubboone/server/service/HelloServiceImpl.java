package com.github.peng49.dubboone.server.service;

import com.github.peng49.dubboone.api.service.HelloService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class HelloServiceImpl implements HelloService {
    @Override
    public String say() {
        return "hello service impl";
    }
}
