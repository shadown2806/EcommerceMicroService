package com.credicoop.servicioNombre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaServer
public class ServicioNombreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioNombreApplication.class, args);
	}

}
