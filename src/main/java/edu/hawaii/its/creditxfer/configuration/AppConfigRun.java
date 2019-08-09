package edu.hawaii.its.creditxfer.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Profile(value = { "localhost", "test" })
@Configuration
@ComponentScan(basePackages = "edu.hawaii.its.creditxfer")
@PropertySources({
        @PropertySource("classpath:custom.properties"),
        @PropertySource(value = "file:${user.home}/.${user.name}-conf/creditxfer-overrides.properties",
                        ignoreResourceNotFound = true)
})
public class AppConfigRun {

    public void init() {
        //Empty
    }

}
