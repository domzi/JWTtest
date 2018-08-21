package config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;

@TestPropertySource("classpath:/resource_server_properties.properties")
@RunWith(SpringRunner.class)
public class ConfigTest {

    @Value("${dataSourceUrl}") String url;
    @Value("${dataSourcePassword") String password;
    @Value("${dataSourceUsername") String username;

    @Test
    public void dataSourceIsProperlyInitialized() {
        Assert.assertThat(url, is("jdbc:mysql://localhost:3306/Book_library?serverTimezone=UTC"));
        Assert.assertThat(password, is(""));
        Assert.assertThat(password, is("root"));
    }
}
