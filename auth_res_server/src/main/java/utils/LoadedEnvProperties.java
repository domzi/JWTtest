package utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

public final class LoadedEnvProperties {
    public final String dataSourceURL;
    public final String dataSourceUsername;
    public final String dataSourcePassword;

    public LoadedEnvProperties(String dataSourceURL,
                               String dataSourceUsername,
                               String dataSourcePassword) {
        this.dataSourceURL = dataSourceURL;
        this.dataSourceUsername = dataSourceUsername;
        this.dataSourcePassword = dataSourcePassword;
    }
}
