package com.example.posdelivery;

import com.example.posdelivery.model.Cart;
import com.example.posdelivery.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
@EnableEurekaClient
public class PosDeliveryApplication {


    public static void main(String[] args) {
        SpringApplication.run(PosDeliveryApplication.class, args);
    }






}
