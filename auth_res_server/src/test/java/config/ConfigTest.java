package config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import static org.hamcrest.CoreMatchers.is;

@TestPropertySource("classpath:/resource_server_properties.properties")
@ContextConfiguration(classes = ContextConfig.class)
@RunWith(SpringRunner.class)
public class ConfigTest {

    @Autowired
    private ApplicationContext ctx;

    @Test
    public void dataSourceIsProperlyInitialized() {
        BasicDataSource dataSource = ctx.getBean("dataSource", BasicDataSource.class);
        Assert.assertThat(dataSource.getPassword(), is(DataSourceConstants.expectedDataSourcePassword));
        Assert.assertThat(dataSource.getUsername(), is(DataSourceConstants.getExpectedDataSourceUsername));
        Assert.assertThat(dataSource.getUrl(), is(DataSourceConstants.expectedDataSourceUrl));
    }

    private static class DataSourceConstants {
        public static final String expectedDataSourceUrl = "jdbc:mysql://localhost:3306/Book_library?serverTimezone=UTC";
        public static final String expectedDataSourcePassword = "";
        public static final String getExpectedDataSourceUsername = "root";
    }
}
