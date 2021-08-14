package kr.or.connect.spring.javaconfig.ex02;

import org.springframework.stereotype.Component;

@Component
public class Engine {

    public Engine() {
        System.out.println("Engine 기본 생성자 호출");
    }

    public void exec() {
        System.out.println("엔진이 동작합니다.");
    }
}
