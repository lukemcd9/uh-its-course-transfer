package edu.hawaii.its.creditxfer.configuration;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.Assert;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
@Profile(value = { "localhost", "prod", "test" })
@EnableTransactionManagement
@PropertySources({
        @PropertySource("classpath:custom.properties"),
        @PropertySource(value = "file://${user.home}/.${user.name}-conf/creditxfer-overrides.properties",
                ignoreResourceNotFound = true),
})
public class DatabaseConfig {

    private static final Log logger = LogFactory.getLog(DatabaseConfig.class);

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.user}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.initialization-mode}")
    private String initializationMode;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String hibernateDdlAuto;

    @Value("${spring.datasource.initialize:false}")
    private Boolean initializeDatasource;

    @PostConstruct
    public void init() {
        logger.info("init; starting...");

        logger.info("init; username            : " + username);
        logger.info("init; url                 : " + url);
        logger.info("init; driverClassName     : " + driverClassName);

        Assert.hasLength(url, "property 'url' is required");
        Assert.hasLength(username, "property 'user' is required");
        Assert.hasLength(driverClassName, "property 'driverClassName' is required");

        Assert.isTrue(initializationMode.equals("never"), "Should be a 'never'");
        Assert.isTrue(hibernateDdlAuto.equals("validate"), "Should be a 'validate'");
        Assert.isTrue(!initializeDatasource, "Should be a False");

        logger.info("init; started.");
    }

    @Bean
    @Primary
    @Profile(value = { "localhost", "prod", "test" })
    @SuppressWarnings("deprecation")
    public DataSource dataSource() {
        Assert.hasLength(url, "'url' is required");
        Assert.hasLength(username, "'username' is required");
        Assert.hasLength(password, "'password' is required");

        OracleDataSource dataSource = null;
        try {
            dataSource = new OracleDataSource();
            dataSource.setURL(url);
            dataSource.setUser(username);
            dataSource.setPassword(password);
            dataSource.getConnection().setReadOnly(true);

            dataSource.setConnectionCachingEnabled(true);
            Properties properties = new Properties();
            properties.setProperty("MinLimit", "0");
            properties.setProperty("MaxLimit", "20");
            properties.setProperty("InitialLimit", "1");
            properties.setProperty("ConnectionWaitTimeout", "120");
            properties.setProperty("InactivityTimeout", "180");
            properties.setProperty("ValidateConnection", "true");
            properties.setProperty("ValidationQuery", "select * from dual");
            dataSource.setConnectionCacheProperties(properties);

        } catch (Exception e) {
            logger.error("Error", e);
        }
        return dataSource;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
