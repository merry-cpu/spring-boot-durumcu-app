package com.can.durumcu;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class DurumcuApplication {

	public static void main(String[] args) {
		SpringApplication.run(DurumcuApplication.class, args);
	}

	@Bean
	public Docket api() { //kodlamai.northwindi gez orda requesthandlerları bul onları dökümantasyona ekle // api bulucu
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
}
