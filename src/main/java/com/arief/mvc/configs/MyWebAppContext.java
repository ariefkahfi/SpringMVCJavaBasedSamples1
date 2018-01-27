package com.arief.mvc.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages =  {"com.arief.mvc.controllers"})
public class MyWebAppContext implements WebMvcConfigurer {


    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/",".jsp");
    }

    @Bean
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver
                =new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSizePerFile(50000000);
        return multipartResolver;
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/assets/");
        registry
                .addResourceHandler("/images/**")
                .addResourceLocations("file:/usr/local/apache/uploads");
    }
}
