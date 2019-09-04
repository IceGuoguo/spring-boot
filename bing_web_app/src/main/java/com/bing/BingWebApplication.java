package com.bing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author guobing
 * @version 1.0
 * @date 2019/9/4 下午4:16
 * @description
 */

@SpringBootApplication
public class BingWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(BingWebApplication.class,args);
    }

    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplate();
    }
}
