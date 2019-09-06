package com.personal.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Auther: Chen
 * @Data: 2019/9/6
 * @Description: com.personal.config
 * @Version: 1.0.0
 */
@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource druid(){
        return new DruidDataSource();
    }
}
