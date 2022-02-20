package com.murad.online1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Online1Application {

    public static void main(String[] args) {
        SpringApplication.run(Online1Application.class, args);
    }

}
