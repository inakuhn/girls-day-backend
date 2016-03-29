package de.girlsday;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan("de.girlsday")
public class GirlsdaybackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(GirlsdaybackendApplication.class, args);
	}

	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("new user").apiInfo(apiInfo()).select()
				.paths(regex("/newuser.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Spring REST Sample with Swagger")
				.description("Spring REST Sample with Swagger").termsOfServiceUrl("uc-lib").contact("Ina Kuhn")
				.license("Apache License Version 2.0")
				.version("2.0").build();
	}
}
