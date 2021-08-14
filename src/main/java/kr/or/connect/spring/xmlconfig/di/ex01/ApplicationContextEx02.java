package kr.or.connect.spring.xmlconfig.di.ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextEx02 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        Car car = (Car) context.getBean("car");
        car.run(); //Engine이 Car 클래스에 자동으로 주입되어 사용되어진다.
    }
}
