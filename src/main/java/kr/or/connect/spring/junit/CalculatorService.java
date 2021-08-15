package kr.or.connect.spring.junit;

public class CalculatorService {

    public int plus(int value1, int value2) {
        return value1 + value2;
    }

    public int minus(int value1, int value2) {
        return value1 - value2;
    }

    public int multiple(int value1, int value2) {
        return value1 * value2;
    }

    /**
     * 나누기의 경우 0으로 나누게되면 ArithmeticException이 발생하기 때문에 throws 설정한 것에 주의하자.
     *
     * @param value1
     * @param value2
     * @return
     * @throws ArithmeticException
     */
    public int divide(int value1, int value2) throws ArithmeticException {
        return value1 / value2;
    }
}
