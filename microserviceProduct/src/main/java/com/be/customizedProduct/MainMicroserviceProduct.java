package com.be.customizedProduct;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients
@EnableSwagger2
public class MainMicroserviceProduct {

    public static void main(String[] args) {SpringApplication.run(MainMicroserviceProduct.class, args);}

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}