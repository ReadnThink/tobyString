package tobyspring.helloboot;

import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HellobootApplication {

    public static void main(String[] args) {
        GenericWebApplicationContext applicationContext = new GenericWebApplicationContext(){
            @Override
            protected void onRefresh() {
                super.onRefresh();
                // 서블릿 펙토리 : 서블릿 컨테이너를 만드는 것을 쉽게 도와줍니다.
                ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
                // serverFactory.getWebServer : 서블릿 컨테이너 생성하는 메소드입니다.
                // 따라서 webServer 가 서블릿 컨테이너 입니다.
                WebServer webServer = serverFactory.getWebServer(servletContext -> {
                    servletContext.addServlet("dispatcherServlet",
                            new DispatcherServlet(this) // DispatcherServlet이 작업을 위임할 applicationContext를 등록
                    ).addMapping("/*"); // 모든 요청을 다 받는다.
                });
                webServer.start();
            }
        }; // 스프링 컨테이너 생성
        applicationContext.registerBean(HelloController.class); // 메타정보를 넣어 Bean을 생성
        applicationContext.registerBean(SimpleHelloService.class);
        applicationContext.refresh(); // Bean을 만드는 명령어
    }

}
