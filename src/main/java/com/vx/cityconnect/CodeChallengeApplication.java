package com.vx.cityconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=
 @Info(title="City Connected API",version="1.0.0", description= "Given origin and destination of city names, the REST API determines if two cities are connected"))
public class CodeChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeChallengeApplication.class, args);
	}

}
