package tobyspring.config.autoconfig;


@MyConfigurationProperties(prefix = "server")
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
