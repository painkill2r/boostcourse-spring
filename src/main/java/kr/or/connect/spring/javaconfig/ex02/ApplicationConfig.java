package kr.or.connect.spring.javaconfig.ex02;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//설정한 패키지 안에 있는 @Component 어노테이션이 설정된 클래스들을 Bean으로 등록
@ComponentScan("kr.or.connect.spring.javaconfig.ex02")
public class ApplicationConfig {
}
