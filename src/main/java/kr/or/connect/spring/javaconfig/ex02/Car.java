package kr.or.connect.spring.javaconfig.ex02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Bean 이름이 지정되지 않는 경우 클래스 이름의 첫 글자를 소문자로 바꾼 이름의 Bean으로 등록된다.
//Camel Case...
@Component
public class Car {

    //Engine 타입의 Bean이 있으면 주입하여 사용하게 된다.
    @Autowired
    private Engine engine;

    public Car() {
        System.out.println("Car 기본 생성자 호출");
    }

    public void run() {
        System.out.println("엔진을 사용하여 달립니다.");
        engine.exec();
    }
}
