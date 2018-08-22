package config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import utils.LoadedEnvProperties;

import javax.sql.DataSource;

@Configuration
@Import(PropertiesConfig.class)
public class DataSourceConfig {

    @Bean
    public DataSource dataSource(final LoadedEnvProperties properties) {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setPassword(properties.dataSourcePassword);
        basicDataSource.setUsername(properties.dataSourceUsername);
        basicDataSource.setUrl(properties.dataSourceURL);
        return basicDataSource;
    }
}
