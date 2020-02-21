package edu.hawaii.its.creditxfer.configuration;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile(value = { "default", "dev" })
@Configuration
@ComponentScan(basePackages = "edu.hawaii.its.creditxfer")
@EntityScan(basePackages = { "edu.hawaii.its.creditxfer.type" })
public class DatabaseConfigDev {

    private static final Log logger = LogFactory.getLog(DatabaseConfigDev.class);

    @Value("${spring.datasource.initialization-mode}")
    private String initializationMode;

    @Value("${spring.jpa.database-platform}")
    private String databasePlatform;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String hibernateDdlAuto;

    @PostConstruct
    public void init() {
        logger.info("init; starting...");
        logger.info("init;   initializationMode: " + initializationMode);

        logger.info("init;     databasePlatform: " + databasePlatform);
        logger.info("init;     hibernateDdlAuto: " + hibernateDdlAuto);

        logger.info("init; started.");
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        DataSource ds =
                DataSourceBuilder
                        .create()
                        .build();
        logger.info("dataSource; ds: " + ds);
        return ds;
    }

}
