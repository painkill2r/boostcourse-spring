package kr.or.connect.spring.jdbc.main;

import kr.or.connect.spring.jdbc.ApplicationConfig;
import kr.or.connect.spring.jdbc.dao.RoleDao;
import kr.or.connect.spring.jdbc.dto.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class selectTest {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        RoleDao roleDao = (RoleDao) context.getBean("roleDao");
        Role role = roleDao.selectById(1);

        System.out.println("role = " + role);
    }
}
