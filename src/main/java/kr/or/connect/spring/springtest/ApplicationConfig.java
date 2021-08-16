package kr.or.connect.spring.springtest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//특정 패키지 이하에서 컴포넌트를 찾도록 설정
//@Component, @Repository, @Service, @Controller, @RestController 등의 어노테이션이 붙은 클래스를 찾아 빈으로 등록한다.
@ComponentScan(basePackages = {"kr.or.connect.spring.springtest"})
public class ApplicationConfig {
}
