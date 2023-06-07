package com.example.demo;

import com.example.demo.Controller.EmployeesController;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@OpenAPIDefinition(
		servers = {
				@Server(url = "https://example.com/api", description = "Default Server URL")
		}, info = @Info(title = "My API", version = "v1", description = "for my API.")
)

@SpringBootApplication
public class RedmineProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedmineProjectApplication.class, args);
	}

}
