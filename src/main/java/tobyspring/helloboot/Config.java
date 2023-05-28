package tobyspring.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration // 메타 애노테이션으로 @Component를 갖고 있습니다.
public class Config {
    @Bean
    public ServletWebServerFactory servletWebServerFactory(){
        return new TomcatServletWebServerFactory();
    }
    @Bean
    public DispatcherServlet dispatcherServlet(){
        // DispatcherServlet이 이용할 컨트롤러를 찾아야 하기때문에 ApplicationContext를 생성자로 주어야합니다.
        // 스프링이 알아서 ApplicationContext를 주입해 줍니다!!
        return new DispatcherServlet();
    }
}
