package com.arief.mvc.configs;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
            MySpringContext.class
        };
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
            MyWebAppContext.class
        };
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        MultipartServletConfig configElement
                = new MultipartServletConfig("/usr/local/apache/uploads/");
        registration.setMultipartConfig(configElement);
    }

    protected String[] getServletMappings() {
        return new String[]{
                "/"
        };
    }
}
