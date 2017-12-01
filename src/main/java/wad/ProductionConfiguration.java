/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad;

import javax.activation.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author lautuomo
 */
@Profile("production")
@Configuration
public class ProductionConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public javax.sql.DataSource dataSource() {
        System.out.println("Hello world!");

        return DataSourceBuilder.create().build();
    }
}
