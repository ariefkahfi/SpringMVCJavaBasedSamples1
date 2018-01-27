package com.arief.mvc.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class MySpringContextAware implements ApplicationContextAware{
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        for (String s : applicationContext.getBeanDefinitionNames()){
            System.out.println(s);
        }
    }
}
