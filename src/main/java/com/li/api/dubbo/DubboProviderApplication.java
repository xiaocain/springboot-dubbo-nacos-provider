package com.li.api.dubbo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author lijinzhou
 * @Date 2023/2/27 18:24
 * @PackageName:com.li.api.dubbo
 * @ClassName: DubboProviderApplication
 * @Description: TODO
 * @Version 1.0
 */
@EnableDubbo
@SpringBootApplication
public class DubboProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboProviderApplication.class);
    }
}
