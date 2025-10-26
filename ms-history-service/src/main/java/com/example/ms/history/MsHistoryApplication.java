package com.example.ms.history;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//@EnableJpaRepositories

@SpringBootApplication

@EnableFeignClients
public class MsHistoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsHistoryApplication.class, args);
    }

}
