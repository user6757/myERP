package com.BEJproject.myERP.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.BEJproject.myERP")
@PropertySource("classpath:db_info.properties")
public class DataBaseConfig {

    @Value("${erp.db.username}")
    private String username;

    @Value("${erp.db.password}")
    private String password;

    @Value("${erp.db.url}")
    private String url;

    @Value("${erp.db.driverClassName}")
    private String driver;

    @Bean
    public DataSource dataSource(){
        HikariConfig config = new HikariConfig();
        config.setUsername(username);
        config.setPassword(password);
        config.setJdbcUrl(url);
        config.setDriverClassName(driver);
        return new HikariDataSource(config);
    }

}
