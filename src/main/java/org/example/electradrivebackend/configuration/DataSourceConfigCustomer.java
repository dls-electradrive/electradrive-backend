package org.example.electradrivebackend.configuration;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "org.example.electradrivebackend.repository.customerrepo",
        entityManagerFactoryRef = "entityManagerFactoryCar",
        transactionManagerRef = "transactionManagerCar"
)
public class DataSourceConfigCustomer {


    @Bean(name = "dataSource1")
    @ConfigurationProperties(prefix = "electradrive.datasource")
    public DataSource dataSource1() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3307/electradrive?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true");
        config.setUsername("root");
        config.setPassword("12345");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return new HikariDataSource(config);
    }


    @Bean(name = "entityManagerFactory1")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory1(DataSource dataSource1) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource1);
        em.setPackagesToScan("org.example.electradrivebackend.model.customermodel");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.getJpaPropertyMap().put("hibernate.hbm2ddl.auto", "update");
        return em;
    }


    @Bean(name = "transactionManagerCar")
    public PlatformTransactionManager transactionManager1(EntityManagerFactory entityManagerFactory1) {
        return new JpaTransactionManager(entityManagerFactory1);
    }
}

