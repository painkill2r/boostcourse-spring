package kr.or.connect.spring.springtest;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    private final CalculatorService calculatorService;

    public MyService(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public int execute(int value1, int value2) {
        /* 테스트 실패를 확인하기 위해서는 아래 주석을 해제하면 된다.
        int value = 0;

        // value = calculatorService.plus(value1, value2); // plus메소드가 호출되지 않도록 주석문 처리하였다.

        return value * 2;
        */
        return calculatorService.plus(value1, value2) * 2;
    }
}
