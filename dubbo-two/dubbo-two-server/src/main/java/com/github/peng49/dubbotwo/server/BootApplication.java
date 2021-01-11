package com.github.peng49.dubbotwo.server;

import com.github.peng49.dubboone.api.service.HelloService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.apache.dubbo.config.utils.ReferenceConfigCache;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@EnableAutoConfiguration
public class BootApplication {

    @DubboReference(url = "zookeeper://localhost:2181")
    private HelloService helloService;

    @Bean
    public ApplicationRunner test()
    {
        return args -> {
            System.out.println("test");
        };
    }


    public static void main(String[] args) {
        /*ReferenceConfig<HelloService> reference = new ReferenceConfig<>();
        reference.setApplication(new ApplicationConfig("dubbo-auto-configuration-provider-demo"));
        reference.setRegistry(new RegistryConfig("zookeeper://localhost:2181"));
        reference.setInterface(HelloService.class);
        HelloService service = reference.get();
        String message = service.say();*/

        /*ReferenceConfig<HelloService> reference = new ReferenceConfig<>();
        reference.setInterface(HelloService.class);
        reference.setGeneric("true");

        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        bootstrap.application(new ApplicationConfig("dubbo-auto-configuration-provider-demo"))
                .registry(new RegistryConfig("zookeeper://localhost:2181"))
                .reference(reference)
                .start();

        HelloService service = ReferenceConfigCache.getCache().get(reference);
        String message = service.say();

        System.out.println(message);

        System.out.println(service.say("good"));*/
        SpringApplication.run(BootApplication.class).close();
    }
}
