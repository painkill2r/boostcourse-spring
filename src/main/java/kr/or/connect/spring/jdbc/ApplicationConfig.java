package kr.or.connect.spring.jdbc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"kr.or.connect.spring.jdbc"})
@Import({DBConfig.class}) //여러 개로 분리되어 있는 설정파일을 읽어 들이도록 설정
public class ApplicationConfig {

}
