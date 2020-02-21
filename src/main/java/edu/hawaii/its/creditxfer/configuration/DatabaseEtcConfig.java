package edu.hawaii.its.creditxfer.configuration;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.Assert;

@Configuration
@EnableTransactionManagement
public class DatabaseEtcConfig {

    private static final Log logger = LogFactory.getLog(DatabaseEtcConfig.class);

    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String hibernateDialect;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String hibernateHbm2ddlAuto;

    @Value("${spring.jpa.properties.hibernate.cache.provider_class}")
    private String hibernateCacheProviderClass;

    @Value("${spring.jpa.properties.hibernate.connection.shutdown}")
    private String hibernateConnectionShutdown;

    @Value("${spring.jpa.properties.hibernate.show_sql}")
    private String hibernateShowSql;

    @Value("${spring.datasource.initialization-mode}")
    private String initializationMode;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String hibernateDdlAuto;

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void init() {
        logger.info("init; starting...");

        logger.info("init;   dataSource: " + dataSource);
        Assert.notNull(dataSource, "property 'dataSource' is required");

        logger.info("init; hibernateHbm2ddlAuto: " + hibernateHbm2ddlAuto);
        logger.info("init;   initializationMode: " + initializationMode);
        logger.info("init;     hibernateDdlAuto: " + hibernateDdlAuto);

        Assert.hasLength(hibernateCacheProviderClass, "property 'hibernateCacheProviderClass' is required");

        logger.info("init; started.");
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        em.setPersistenceUnitName("creditxferPersistenceUnit");
        em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        em.setPackagesToScan("edu.hawaii.its.creditxfer.type");

        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setDataSource(getDataSource());
        em.setJpaProperties(jpaProperties());

        return em;
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    public DataSource getDataSource() {
        return dataSource;
    }

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
