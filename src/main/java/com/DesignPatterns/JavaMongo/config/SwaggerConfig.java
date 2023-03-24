package com.DesignPatterns.JavaMongo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.select()
				.apis(RequestHandlerSelectors
						.basePackage("com.DesignPatterns.JavaMongo.resources") )
				.paths(PathSelectors.any())
				.build()
				.apiInfo(aiApiInfo());
	}
	
	private ApiInfo aiApiInfo() {
		return new ApiInfoBuilder()
				.title("Microblog para conversa do andamento de um bootcamp Java")
				.description("Api projeto, onde os usuários fazem posts e comentários sobre o bootcamp Java onde estão inscritos.")
				.version("1.0")
				.contact(contact())
				.build();
		
	}
	
	
	private Contact contact() {
		return new Contact("Karen Ribeiro", "https://github.com/Karenkfr", "karen.ferrazribeiro@hotmail.com");
	}
}
