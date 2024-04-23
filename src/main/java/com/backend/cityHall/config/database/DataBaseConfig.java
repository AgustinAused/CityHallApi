package com.backend.cityHall.config.database;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfig {

        @Bean
        @ConfigurationProperties(prefix = "datasource.my-config")
        public DataSource dataSource(){
            return DataSourceBuilder.create().build();
        }

        @Bean
        public JdbcTemplate jdbcTemplate(){
            return new JdbcTemplate(dataSource());
        }

        @Bean
        public NamedParameterJdbcTemplate namedParameterJdbcTemplate(){
            return new NamedParameterJdbcTemplate(dataSource());
        }
}