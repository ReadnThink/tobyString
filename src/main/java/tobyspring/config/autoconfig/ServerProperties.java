package tobyspring.config.autoconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tobyspring.config.MyAutoConfiguration;


@MyAutoConfigurationProperties(prefix = "server")
public class ServerProperties {
    private String contextPath;

    private int port;

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getContextPath() {
        return contextPath;
    }

    public int getPort() {
        return port;
    }
}
