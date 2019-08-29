package com.blaisedev.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication {

	@Bean
	public RouteLocator myRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("movie-info-service", r -> r.path("/rest/**").or().path("/movies/**")
						.uri("lb://movie-info-service"))
				.route("movie-catalog-service", r -> r.path("/catalog/**")
						.uri("lb://movie-catalog-service"))
				.route("ratings-data-service", r -> r.path("/ratingsdata/**")
						.uri("lb://ratings-data-service"))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}



}
