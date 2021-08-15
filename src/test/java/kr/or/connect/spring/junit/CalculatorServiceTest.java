package kr.or.connect.spring.junit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorServiceTest {

    CalculatorService calculatorService;

    /**
     * 테스트 메소드 실행 전 실행된다.
     * 해당 테스트 클래스 실행 시에는 총 3번 실행된다.
     */
    @Before
    public void init() {
        this.calculatorService = new CalculatorService();
    }

    @Test
    public void plus() throws Exception {
        //given
        int value1 = 10;
        int value2 = 5;

        //when
        int result = calculatorService.plus(value1, value2);

        //then
        Assert.assertEquals(15, result); //결과와 15가 같을 경우에만 성공
        //Assert.assertEquals(16, result); //Fail!
    }

    @Test
    public void divide() throws Exception {
        //given
        int value1 = 10;
        int value2 = 5;

        //when
        int result = calculatorService.divide(value1, value2);

        //then
        Assert.assertEquals(2, result); //결과와 2가 같을 경우에만 성공
        //Assert.assertEquals(3, result); //Fail!
    }

    @Test
    public void divideExceptionTest() throws Exception {
        //given
        int value1 = 10;
        int value2 = 0;

        try {
            calculatorService.divide(value1, value2);
        } catch (ArithmeticException ae) {
            Assert.assertTrue(true); //이부분이 실행되었다면 성공
            return; //메소드를 더이상 실행하지 않는다.
        }

        Assert.fail(); //이부분이 실행되면 무조건 실패
    }
}