package utils;

import org.springframework.core.env.Environment;

public class EnvPropertiesLoader {

    private final Environment env;

    public EnvPropertiesLoader(Environment env) {
        this.env = env;
    }

    public LoadedEnvProperties load() {

        return new LoadedEnvProperties(
                env.getProperty("dataSourceURL"),
                env.getProperty("dataSourceUsername"),
                env.getProperty("dataSourcePassword"));
    }
}
