package kr.or.connect.spring.springtest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MyServiceTest {

    @InjectMocks
    MyService myService;

    @Mock
    CalculatorService calculatorService;

    @Test
    public void execute() throws Exception {
        // given
        int value1 = 5;
        int value2 = 10;

        //given()은 가짜 객체(calculatorService)가 동작하는 방법을 규정하는 메소드이다.
        //여기서는 calculatorService.plus(5, 10)를 호출하면 15를 반환하도록 하라는 의미를 갖는다.
        given(calculatorService.plus(5, 10)).willReturn(15);

        // when
        int result = myService.execute(value1, value2); //무조건 30이 반환될 것이다.

        // then
        //verify()는 파라미터로 들어온 객체의 plus메소드가 호출된 적이 있는지 검증한다.
        //plus(anyInt(), anyInt())는 어떤 정수든지 2개를 파라미터로 넣어서 plus() 메소드를 호출했는지를 검증한다.
        verify(calculatorService).plus(anyInt(), anyInt());

        Assert.assertEquals(30, result);
    }
}