package util;

import model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

public class test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/conf/applicationContext.xml", "/conf/applicationContext-beans.xml");
        UserService userService = (UserService) context.getBean("userService");
        User user = new User();
        user.setName("2");
        user.setPassword("x");
        Object[] objects = userService.login(user);
        System.out.println(objects[1]);
    }
}
