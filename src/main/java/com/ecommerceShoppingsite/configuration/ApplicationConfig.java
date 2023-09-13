package com.ecommerceShoppingsite.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfig {

	public Docket getDocket() {
		Contact contact=new Contact("TestYantra","www.testyantra.com","testyantra@mail.com");
		@SuppressWarnings("rawtypes")
		List<VendorExtension> extensions=new ArrayList<>();
		
		ApiInfo apiInfo=new ApiInfo("Ecommerce shopping app","This App is to Order your needs Online to your door step","1.0","www.testyantra.com",
				 contact,"Apache-Tomcat-9.0","www.testyantra.global.com",extensions);
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ecommerceShoppingsite")).build().apiInfo(apiInfo)
				.useDefaultResponseMessages(false);
	}
}
