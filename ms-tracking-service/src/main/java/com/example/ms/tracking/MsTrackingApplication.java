package com.example.ms.tracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//@EnableJpaRepositories

@SpringBootApplication

@EnableFeignClients
public class MsTrackingApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsTrackingApplication.class, args);
        System.out.println("🚀 ms-tracking-service iniciado correctamente");
    }
}