package br.com.proonto.configs;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

 @EnableJpaRepositories(basePackages = {"br.com.proonto.repositories"})
 @EntityScan(basePackages = {"br.com.proonto.models.entities"})
 @ComponentScan(basePackages = {"br.com.proonto.controllers",
 		"br.com.proonto.services", "br.com.proonto.configs",
 		"br.com.proonto.exceptions"
 })
@Configuration
public class GeralConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

    //    @Bean
//    public PasswordEncoder getPasswordEncoder() {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        return encoder;
//    }
    @Bean
    public FreeMarkerViewResolver freemarkerViewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setCache(true);
        resolver.setPrefix("");
        resolver.setSuffix(".ftlh");
        return resolver;
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API to manager application Proonto")
                        .version("v1")
                        .description("RESTful API develop with Java 11 and Spring Boot 2.7.2")
                        .termsOfService("https://www.idip.com.br")
                        .license(
                                new License()
                                        .name("Apache 2.0")
                                        .url("https://www.idip.com.br")
                        )
                );
    }

}
