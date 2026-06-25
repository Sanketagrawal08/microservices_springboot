package com.example.userservice.UserServic.config;

import org.slf4j.Logger;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {
    @Bean
    @LoadBalanced // we have to make aisa resttemplate that baalnced load from other services basically name se call ho sake
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    }
