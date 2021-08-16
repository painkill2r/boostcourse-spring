package kr.or.connect.spring.jdbc.main;

import kr.or.connect.spring.jdbc.ApplicationConfig;
import kr.or.connect.spring.jdbc.dao.RoleDao;
import kr.or.connect.spring.jdbc.dto.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class deleteTest {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        RoleDao roleDao = (RoleDao) context.getBean("roleDao");

        int count = roleDao.deleteById(100);

        System.out.println(count + "건 삭제 완료.");
    }
}
