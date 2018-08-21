package config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:/resource_server_properties.properties")
public class ContextConfig {

    @Value("${dataSourceUrl}") String url;
    @Value("${dataSourcePassword}") String password;
    @Value("${dataSourceUsername}") String username;

    @Bean
    public DataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setPassword(password);
        basicDataSource.setUsername(username);
        basicDataSource.setUrl(url);
        return basicDataSource;
    }
}
