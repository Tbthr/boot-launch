package com.power.bootlaunch.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

//    @Bean(initMethod="init", destroyMethod="close", name="primaryDataSource")
    @Primary
    @Bean(name = "primaryDataSource")
    @ConfigurationProperties(prefix = "primarydb")
    public DataSource primaryDataSource() {
        return new AtomikosDataSourceBean();
    }

    //jta数据源1
    @Bean(name = "secondaryDataSource")
    @ConfigurationProperties(prefix = "secondarydb")
    public DataSource secondaryDataSource()  {
        return new AtomikosDataSourceBean();
    }

    @Bean
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource primaryDataSource) {
        return new JdbcTemplate(primaryDataSource);
    }

    @Bean
    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource") DataSource secondaryDataSource) {
        return new JdbcTemplate(secondaryDataSource);
    }
}