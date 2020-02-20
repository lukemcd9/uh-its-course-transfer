package edu.hawaii.its.creditxfer.configuration;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.Assert;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
@EnableTransactionManagement
@PropertySources({
        @PropertySource("classpath:custom.properties"),
        @PropertySource(value = "file://${user.home}/.${user.name}-conf/creditxfer-overrides.properties",
                        ignoreResourceNotFound = true),
})
public class DatabaseConfig {

    private static final Log logger = LogFactory.getLog(SecurityConfig.class);

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.user}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.dataSource.class}")
    private String driverClassName;

//    @Value("${app.datasource.url}")
//    private String url;
//
//    @Value("${app.datasource.username}")
//    private String username;
//
//    @Value("${app.datasource.password}")
//    private String password;
//
//    @Value("${app.datasource.driver-class-name}")
//    private String driverClassName;

    @PostConstruct
    public void init() {
        Assert.hasLength(url, "property 'url' is required");
        Assert.hasLength(username, "property 'user' is required");
        Assert.hasLength(driverClassName, "property 'driverClassName' is required");
        Assert.hasLength(hibernateCacheProviderClass, "property 'hibernateCacheProviderClass' is required");
    }

    @Bean
    @Profile("dev")
    public DataSource dataSourceDev() {
        Assert.hasLength(url, "'url' is required");

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    @Primary
    @Profile(value= {"localhost", "prod", "test"})
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
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        em.setPersistenceUnitName("creditxferPersistenceUnit");
        em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        em.setPackagesToScan("edu.hawaii.its.creditxfer.type");

        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(jpaProperties());
        em.setDataSource(dataSource());

        return em;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Value("${env.db.hibernate.dialect}")
    private String hibernateDialect;

    @Value("${env.db.hibernate.hbm2ddl.auto}")
    private String hibernateHbm2ddlAuto;

    @Value("${env.db.hibernate.cache.provider_class}")
    private String hibernateCacheProviderClass;

    @Value("${env.db.hibernate.connection.shutdown}")
    private String hibernateConnectionShutdown;

    @Value("${env.db.hibernate.show_sql}")
    private String hibernateShowSql;

//    @Value("${app.jpa.properties.hibernate.dialect}")
//    private String hibernateDialect;
//
//    @Value("${app.jpa.hibernate.ddl-auto}")
//    private String hibernateHbm2ddlAuto;
//
//    @Value("${app.jpa.properties.hibernate.cache.provider_class}")
//    private String hibernateCacheProviderClass;
//
//    @Value("${app.jpa.properties.hibernate.connection.shutdown}")
//    private String hibernateConnectionShutdown;
//
//    @Value("${app.jpa.show-sql}")
//    private String hibernateShowSql;

    protected Properties jpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", hibernateDialect);
        properties.setProperty("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
        properties.setProperty("hibernate.cache.provider_class", hibernateCacheProviderClass);
        properties.setProperty("hibernate.connection.shutdown", hibernateConnectionShutdown);
        properties.setProperty("hibernate.show_sql", hibernateShowSql);

        return properties;
    }

}
