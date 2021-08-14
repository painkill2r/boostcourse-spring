package kr.or.connect.spring.xmlconfig.ioc.ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextEx {

    public static void main(String[] args) {
        //classpath => resources 디렉토리를 가르킴.
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        UserBean userBean = (UserBean) context.getBean("userBean");
        userBean.setName("HENU");
        System.out.println(userBean.getName());

        UserBean userBean2 = (UserBean) context.getBean("userBean");
        System.out.println(userBean == userBean2);
    }
}
