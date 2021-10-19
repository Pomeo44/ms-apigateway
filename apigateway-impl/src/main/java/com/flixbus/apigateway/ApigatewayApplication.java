package com.flixbus.apigateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@SpringBootApplication
@EnableJpaRepositories
@EnableDiscoveryClient
@EnableFeignClients
public class ApigatewayApplication {

    public static void main(String[] args) {
        log.info("Version: {}", ApigatewayApplication.class.getPackage().getImplementationVersion());
        SpringApplication.run(ApigatewayApplication.class, args);
    }
}
