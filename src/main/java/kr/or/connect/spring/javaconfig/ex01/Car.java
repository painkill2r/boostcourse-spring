package kr.or.connect.spring.javaconfig.ex01;

public class Car {

    private Engine engine;

    public Car() {
        System.out.println("Car 기본 생성자 호출");
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void run() {
        System.out.println("엔진을 사용하여 달립니다.");
        engine.exec();
    }
}
