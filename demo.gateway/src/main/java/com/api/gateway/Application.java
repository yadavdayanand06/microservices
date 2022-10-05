package com.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	/**
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return 
		builder.routes()
		 .route("USER-SERVICE", r->r.path("/departments/**")
				 .and()
				 .uri("lb://DEPARTMENT-SERVICE/"))
		 .route("USER-SERVICE",  r->r.path("/users/**")
				 .and()
				 .uri("lb://USER-SERVICE/"))
		 .build();
		
	}  **/

}
