package com.arief.mvc.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"com.arief.mvc.beans"})
public class MySpringContext {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource
                = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_mvc1");
        dataSource.setUsername("arief");
        dataSource.setPassword("arief");

        return dataSource;
    }

    @Bean
    public Properties hibernateProperties(){
        Properties props = new Properties();
        props.setProperty("hibernate.hbm2ddl.auto","update");
        props.setProperty("hibernate.show_sql","true");
        props.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL57Dialect");
        return props;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(){
        LocalSessionFactoryBean sessionFactoryBean
                =new LocalSessionFactoryBean();
        sessionFactoryBean.setPackagesToScan("com.arief.mvc.models");
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        return sessionFactoryBean;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager(){
        HibernateTransactionManager hibernateTransactionManager
                =new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactoryBean().getObject());
        return hibernateTransactionManager;
    }

    @Bean
    public TransactionTemplate hibernateTransactionTemplate(){
        TransactionTemplate transactionTemplate
                =new TransactionTemplate();
        transactionTemplate.setTransactionManager(hibernateTransactionManager());
        return transactionTemplate;
    }
}
