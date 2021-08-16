package kr.or.connect.spring.springtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextEx {

    public static void main(String[] args) {

        //ApplicationConfig.class 설정파일을 읽어들이는 ApplicationContext객체를 생성한다.
        //아래 한줄이 실행되면서 컴포넌트 스캔을 하고, 컴포넌트를 찾으면 인스턴스를 생성하여 ApplicationContext가 관리하게 된다.
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        //ApplicationContext가 관리하는 CalculatorService.class타입의 객체를 요청한다.
        CalculatorService calculatorService = (CalculatorService) context.getBean("calculatorService");

        //ApplicationContext로 부터 받은 객체를 이용하여 덧셈을 구한다.
        System.out.println(calculatorService.plus(10, 5));
    }
}
