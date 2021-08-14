package kr.or.connect.spring.xmlconfig.di.ex01;

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

    /**
     * IoC/DI를 사용하지 않고, 직접 객체를 만들어서 Car 클래스를 실행시키는 경우
     *
     * @param args
     */
//    public static void main(String[] args) {
//        Engine engine = new Engine();
//        Car car = new Car();
//        car.setEngine(engine);
//        car.run();
//    }
}
