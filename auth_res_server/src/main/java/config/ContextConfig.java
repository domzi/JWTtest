package config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import utils.EnvPropertiesLoader;
import utils.LoadedEnvProperties;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:/resource_server_properties.properties")
public class ContextConfig {

    @Bean
    public LoadedEnvProperties loadedEnvProperties(final Environment env) {
        EnvPropertiesLoader envPropertiesLoader = new EnvPropertiesLoader(env);
        return envPropertiesLoader.load();
    }

    @Bean
    public DataSource dataSource(final LoadedEnvProperties properties) {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setPassword(properties.dataSourcePassword);
        basicDataSource.setUsername(properties.dataSourceUsername);
        basicDataSource.setUrl(properties.dataSourceURL);
        return basicDataSource;
    }
}
