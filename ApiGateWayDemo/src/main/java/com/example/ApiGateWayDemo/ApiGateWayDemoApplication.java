package com.example.ApiGateWayDemo;

import com.example.ApiGateWayDemo.Filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication

public class ApiGateWayDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGateWayDemoApplication.class, args);
	}
	@Bean
	public RouteLocator getRoutes(RouteLocatorBuilder builder){

		return builder.routes()
				.route( p-> p
						.path("/auth-app-v1/**")
						.uri("http://localhost:4444/*"))
				.route(p->p
						.path("/pizza-app-v1/**")
						.uri("http://localhost:5555/*"))
				.build();
	}
	@Bean
	public FilterRegistrationBean jwtFilter() {

		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new JwtFilter());
		filterRegistrationBean.addUrlPatterns("/auth-app-v1/*","/pizza-app-v1/*");
		return filterRegistrationBean;
	}

}
