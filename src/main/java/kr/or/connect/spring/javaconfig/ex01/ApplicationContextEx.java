package kr.or.connect.spring.javaconfig.ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextEx {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        //Car car = (Car) context.getBean("car");
        Car car = context.getBean(Car.class);
        car.run();
    }
}
