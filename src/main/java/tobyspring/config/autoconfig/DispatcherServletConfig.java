package tobyspring.config.autoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class DispatcherServletConfig {
    @Bean
    public DispatcherServlet dispatcherServlet(){
        // DispatcherServlet이 이용할 컨트롤러를 찾아야 하기때문에 ApplicationContext를 생성자로 주어야합니다.
        // 스프링이 알아서 ApplicationContext를 주입해 줍니다!!
        return new DispatcherServlet();
    }
}
