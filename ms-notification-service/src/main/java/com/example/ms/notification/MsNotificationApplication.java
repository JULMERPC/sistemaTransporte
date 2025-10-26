package com.example.ms.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//@EnableJpaRepositories

@SpringBootApplication

@EnableFeignClients
public class MsNotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsNotificationApplication.class, args);
        System.out.println("🚀 ms-notification-service iniciado correctamente");
    }
}