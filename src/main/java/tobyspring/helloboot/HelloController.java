package tobyspring.helloboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

public class HelloController {
    public String hello(String name){
        SimpleHelloService helloService = new SimpleHelloService();
        // 컨트롤러의 중요한 역할인 유저의 요청사항을 검증하기
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
