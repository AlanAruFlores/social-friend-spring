package com.ar.social_friend.social_friend.conf;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.ar.social_friend.social_friend")
public class DataSourceConfig implements WebMvcConfigurer {

    @Bean
    @Qualifier("devDataSource")
    @Profile("dev")
    public DataSource getDataSourceDev(
            @Value("${dev.datasource.driver-class-name}") String driver,
            @Value("${dev.datasource.url}") String url,
            @Value("${dev.datasource.username}") String username,
            @Value("${dev.datasource.password}") String password
            ) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    @Qualifier("testDataSource")
    @Profile("test")
    public DataSource getDataSourceTest(
            @Value("${test.datasource.driver-class-name}") String driver,
            @Value("${test.datasource.url}") String url,
            @Value("${test.datasource.username}") String username,
            @Value("${test.datasource.password}") String password
    ) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean(name="entityManagerFactory")
    @Profile("dev")
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryDev(
            @Qualifier("devDataSource") DataSource dataSource,
            @Value("${dev.jpa.show-sql}") String showSql,
            @Value("${dev.jpa.properties.hibernate.dialect}") String dialect,
            @Value("${dev.jpa.hibernate.ddl-auto}") String ddlAuto) {

        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();

        emf.setDataSource(dataSource);
        emf.setPackagesToScan("com.ar.social_friend.social_friend.domain");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties jpaProperties = getProperties(showSql,dialect,ddlAuto);

        emf.setJpaProperties(jpaProperties);

        return emf;
    }

    @Bean(name="entityManagerFactory")
    @Profile("test")
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryTest(
            @Qualifier("testDataSource") DataSource dataSource,
            @Value("${test.jpa.show-sql}") String showSql,
            @Value("${test.jpa.properties.hibernate.dialect}") String dialect,
            @Value("${test.jpa.hibernate.ddl-auto}") String ddlAuto) {

        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();

        emf.setDataSource(dataSource);
        emf.setPackagesToScan("com.ar.social_friend.social_friend.domain");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties jpaProperties = getProperties(showSql,dialect,ddlAuto);

        emf.setJpaProperties(jpaProperties);

        return emf;
    }

    private Properties getProperties(
            String showSql,
            String dialect,
            String ddlAuto
    ){
        Properties properties = new Properties();
        properties.setProperty("hibernate.show_sql", showSql);
        properties.setProperty("hibernate.dialect", dialect);
        properties.setProperty("hibernate.hbm2ddl.auto", ddlAuto);

        return properties;
    }


    @Bean(name="transactionManager")
    public PlatformTransactionManager getPlatformTransactionManager(EntityManagerFactory entityManagerFactory){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        return jpaTransactionManager;
    }

}
