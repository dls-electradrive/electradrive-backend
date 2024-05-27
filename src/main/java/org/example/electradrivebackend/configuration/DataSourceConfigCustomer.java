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
        entityManagerFactoryRef = "entityManagerFactoryCustomer",
        transactionManagerRef = "transactionManagerCustomer"
)
public class DataSourceConfigCustomer {


    @Bean(name = "dataSourceCustomer")
    @ConfigurationProperties(prefix = "electradrive.datasource")
    public DataSource dataSourceCustomer() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://host.docker.internal:3307/electradrive?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true");
        config.setUsername("root");
        config.setPassword("12345");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return new HikariDataSource(config);
    }


    @Bean(name = "entityManagerFactoryCustomer")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryCustomer(DataSource dataSourceCustomer) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSourceCustomer);
        em.setPackagesToScan("org.example.electradrivebackend.model.customermodel");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.getJpaPropertyMap().put("hibernate.hbm2ddl.auto", "update");
        return em;
    }


    @Bean(name = "transactionManagerCustomer")
    public PlatformTransactionManager transactionManagerCustomer(EntityManagerFactory entityManagerFactoryCustomer) {
        return new JpaTransactionManager(entityManagerFactoryCustomer);
    }
}

