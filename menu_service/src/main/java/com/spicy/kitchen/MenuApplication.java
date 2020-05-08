package com.spicy.kitchen;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@SpringBootApplication
//@EnableWebSecurity
@EnableSwagger2
//@EnableJpaRepositories("com.spicy.kitchen.dao")
@ComponentScan({"com.spicy.kitchen.controller","com.spicy.kitchen.service"})
//@EnableDiscoveryClient
//@EnableCircuitBreaker
public class MenuApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuApplication.class, args);
		
        }
	

	@Bean 
	  public Docket swaggerConfiguration() {
	  
	  return new Docket(DocumentationType.SWAGGER_2)
			  .select()
			  .paths(PathSelectors.any())
			  .apis(RequestHandlerSelectors.basePackage("com.spicy.kitchen")) 
			  .build().apiInfo(apiDetails());
	}
	  private ApiInfo apiDetails() {
	// TODO Auto-generated method stub
	
	return new ApiInfo("Spicy Kitchen Restaurant Menu api", 
			
				"Swagger api documentation for Menu",					
				"2.0.0",					
				"Free to use",					
				new springfox.documentation.service.Contact("Restaurant", "http://restaurant.io", "spicykitchen@gmail.com"),					
				"API license", 
				"http://restaurant.io",					
				Collections.emptyList());
				
	
}
}