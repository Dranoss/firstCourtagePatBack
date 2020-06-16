package com.patrimoine.website.core;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class dataSourceConfiguration{

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.username(System.getenv("db_username"));
        dataSourceBuilder.password(System.getenv("db_password"));
        dataSourceBuilder.url(System.getenv("db_url"));

        return dataSourceBuilder.build();
    }

}
