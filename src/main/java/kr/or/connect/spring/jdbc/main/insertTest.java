package kr.or.connect.spring.jdbc.main;

import kr.or.connect.spring.jdbc.ApplicationConfig;
import kr.or.connect.spring.jdbc.dao.RoleDao;
import kr.or.connect.spring.jdbc.dto.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class insertTest {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        RoleDao roleDao = (RoleDao) context.getBean("roleDao");
        Role role = new Role();
        role.setRoleId(100);
        role.setDescription("ROLE_USER");

        int count = roleDao.insert(role);

        System.out.println(count + "건 입력 완료.");
    }
}
