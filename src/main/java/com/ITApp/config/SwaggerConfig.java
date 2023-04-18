/*
 * package com.ITApp.config;
 * 
 * 
 * import org.springdoc.core.GroupedOpenApi; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * 
 * 
 * @Configuration
 * 
 * 
 * public class SwaggerConfig {
 * 
 * @Bean public GroupedOpenApi publicApi() { return GroupedOpenApi.builder()
 * .group("springshop-public") .pathsToMatch("/public/**") .build(); }
 * 
 * @Bean public GroupedOpenApi adminApi() { return GroupedOpenApi.builder()
 * .group("springshop-admin") .pathsToMatch("/admin/**")
 * .addOpenApiMethodFilter(method -> method.isAnnotationPresent(Admin.class))
 * .build(); } }
 */