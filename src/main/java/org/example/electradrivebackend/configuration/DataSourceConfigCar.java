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
        basePackages = "org.example.electradrivebackend.repository.carrepo",
        entityManagerFactoryRef = "entityManagerFactoryCar",
        transactionManagerRef = "transactionManagerCar"
)
public class DataSourceConfigCar {

    @ConfigurationProperties(prefix = "carstorage.datasource")
    @Bean(name = "dataSourceCar")
    public DataSource dataSourceCar() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://host.docker.internal:3307/carstorage?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true");
        config.setUsername("root");
        config.setPassword("12345");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return new HikariDataSource(config);
    }

    @Bean(name = "entityManagerFactoryCar")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryCar(DataSource dataSourceCar) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSourceCar);
        em.setPackagesToScan("org.example.electradrivebackend.model.carmodel");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        return em;
    }

    @Bean(name = "transactionManagerCar")
    public PlatformTransactionManager transactionManagerCar(EntityManagerFactory entityManagerFactoryCar) {
        return new JpaTransactionManager(entityManagerFactoryCar);
    }
}
