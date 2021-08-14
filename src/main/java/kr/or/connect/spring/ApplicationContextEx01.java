package kr.or.connect.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextEx01 {

    public static void main(String[] args) {
        //classpath => resources 디렉토리를 가르킴.
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        System.out.println("초기화...");

        UserBean userBean = (UserBean) context.getBean("userBean");
        userBean.setName("kang");

        System.out.println(userBean.getName());

        UserBean userBean2 = (UserBean) context.getBean("userBean");

        System.out.println(userBean == userBean2);
    }
}
