package com.example.SpringBootSwagger2Demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class SpringBootSwagger2DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSwagger2DemoApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		// Return a prepared Docket instance
//		new Docket(DocumentationType.SWAGGER_2).select();  // ApiSelectorBuilder
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/**"))
				.apis(RequestHandlerSelectors.basePackage("com.example"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
//		public ApiInfo(String title, String description, String version, String termsOfServiceUrl, String contactName, String license, String licenseUrl)
//		public ApiInfo(String title, String description, String version, String termsOfServiceUrl, Contact contact, String license, String licenseUrl, Collection< VendorExtension > vendorExtensions)
		return new ApiInfo(
				"Address Book API",
				"Sample API for Demo",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Rushabh Jain", "https://github.com/rushabh-jain-452", "rushabhjain452@gmail.com"),
				"API License",
				"https://github.com/rushabh-jain-452",
				Collections.emptyList()
		);
	}

}
